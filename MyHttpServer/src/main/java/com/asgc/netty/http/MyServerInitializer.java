package com.asgc.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * Author: yangwen
 * Date:  2018/9/3
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        System.out.println("initChannel ...");

        //http协议编解码
        pipeline.addLast("httpServerCodec", new HttpServerCodec());
        pipeline.addLast("myHttpServerHandler", new MyHttpServerHandler());
    }

}
