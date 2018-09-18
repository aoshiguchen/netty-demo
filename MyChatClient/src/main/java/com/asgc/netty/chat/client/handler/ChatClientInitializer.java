package com.asgc.netty.chat.client.handler;

import com.asgc.netty.chat.client.coder.MessageDecoder;
import com.asgc.netty.chat.client.coder.MessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * TODO
 * Author: yangwen
 * Date:  2018/9/5
 */
public class ChatClientInitializer  extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
        pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
        pipeline.addLast(new ChatClientHandler());

        pipeline.addLast(new MessageDecoder());
        pipeline.addLast(new MessageEncoder());
        pipeline.addLast(new MessageHandler());

        pipeline.addLast(new TextMessageHandler());
        pipeline.addLast(new ImageMessageHandler());
        pipeline.addLast(new OnlineMessageHandler());
        pipeline.addLast(new OfflineMessageHandler());
        pipeline.addLast(new LoginMessageHandler());

    }

}
