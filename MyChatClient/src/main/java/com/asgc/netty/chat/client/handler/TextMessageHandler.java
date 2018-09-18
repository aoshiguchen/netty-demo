package com.asgc.netty.chat.client.handler;

import com.asgc.netty.chat.client.model.TextMessage;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文本消息处理器
 * Author: yangwen
 * Date:  2018/9/6
 */
public class TextMessageHandler  extends SimpleChannelInboundHandler<TextMessage> {

    private static final Logger logger = LoggerFactory.getLogger(TextMessageHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextMessage msg) throws Exception {
        Channel channel = ctx.channel();

        System.out.println("【" + msg.getFromName() + "】："  + msg.getContent());

        //通知执行下一个handler
        ctx.fireChannelRead(msg);

    }
}
