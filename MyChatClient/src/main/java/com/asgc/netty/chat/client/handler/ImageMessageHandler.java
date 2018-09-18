package com.asgc.netty.chat.client.handler;

import com.asgc.netty.chat.client.model.ImageMessage;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 图片消息处理器
 * Author: yangwen
 * Date:  2018/9/6
 */
public class ImageMessageHandler   extends SimpleChannelInboundHandler<ImageMessage> {

    private static final Logger logger = LoggerFactory.getLogger(TextMessageHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ImageMessage msg) throws Exception {
        Channel channel = ctx.channel();

        System.out.println("【" + msg.getFromName() + "】：图片 [" + "url:" + msg.getUrl() + ",描述:" + msg.getDesc() + "]");

        //通知执行下一个handler
        ctx.fireChannelRead(msg);
    }

}
