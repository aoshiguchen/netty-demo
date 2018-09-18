package com.asgc.netty.chat.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息处理器
 * Author: yangwen
 * Date:  2018/9/5
 */
public class ChatClientHandler  extends SimpleChannelInboundHandler<String> {

    private static final Logger logger = LoggerFactory.getLogger(ChatClientHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        logger.info("解析之前的消息：" + msg);

        //通知执行下一个handler
        ctx.fireChannelRead(msg);
    }

}
