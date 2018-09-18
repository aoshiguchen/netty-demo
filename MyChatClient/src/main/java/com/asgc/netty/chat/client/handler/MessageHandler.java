package com.asgc.netty.chat.client.handler;

import com.asgc.netty.chat.client.model.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息处理器
 * Author: yangwen
 * Date:  2018/9/6
 */
public class MessageHandler   extends SimpleChannelInboundHandler<Message> {

    private static final Logger logger = LoggerFactory.getLogger(MessageHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        logger.info(msg.getFromName() + " 发送了一条消息，消息类型：" + msg.getType());

        //通知执行下一个handler
        ctx.fireChannelRead(msg);

    }
}
