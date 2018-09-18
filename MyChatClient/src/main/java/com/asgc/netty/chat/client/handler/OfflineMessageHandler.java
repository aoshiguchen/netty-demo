package com.asgc.netty.chat.client.handler;

import com.asgc.netty.chat.client.model.OfflineMessage;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 下线消息处理器
 * Author: yangwen
 * Date:  2018/9/6
 */
public class OfflineMessageHandler extends SimpleChannelInboundHandler<OfflineMessage> {

    private static final Logger logger = LoggerFactory.getLogger(OfflineMessageHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, OfflineMessage msg) throws Exception {
        Channel channel = ctx.channel();

        System.out.println("【" + msg.getFromName() + "】：" + msg.getUserName() + "下线了");

        //通知执行下一个handler
        ctx.fireChannelRead(msg);
    }
}
