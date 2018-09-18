package com.asgc.netty.websocket.handler;

import com.asgc.netty.websocket.coder.MessageDecoder;
import com.asgc.netty.websocket.coder.MessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * TODO
 * Author: yangwen
 * Date:  2018/9/7
 */
public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        //websocket在建立握手连接时，数据是通过HTTP协议传输的，建立连接之后，数据通过websocket协议传输
        //后缀带Codec的代表既负责编码、也负责解码
        pipeline.addLast(new HttpServerCodec());
        //ChannelDuplexHandler这种handler在接收数据、发送数据时都会执行，一般用于在数据外包装一层、添加头信息、结束标志
        //发送数据时包装数据、接收数据时解开包装
        pipeline.addLast(new ChunkedWriteHandler());
        //负责将原始的http数据聚合成HttpObject
        pipeline.addLast(new HttpObjectAggregator(8192));
        //websocket协议
        pipeline.addLast(new WebSocketServerProtocolHandler("/test"));

        pipeline.addLast(new MessageDecoder());
        pipeline.addLast(new MessageEncoder());
        pipeline.addLast(new MessageHandler());
    }
}
