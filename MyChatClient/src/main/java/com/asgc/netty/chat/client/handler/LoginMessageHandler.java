package com.asgc.netty.chat.client.handler;

import com.asgc.netty.chat.client.model.LoginMessage;
import com.asgc.netty.chat.client.util.UserHelper;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 登陆消息处理器
 * Author: yangwen
 * Date:  2018/9/7
 */
public class LoginMessageHandler   extends SimpleChannelInboundHandler<LoginMessage> {

    private static final Logger logger = LoggerFactory.getLogger(LoginMessageHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginMessage msg) throws Exception {
        Channel channel = ctx.channel();

        System.out.println("【" + msg.getFromName() + "】：登陆成功！用户ID:" + msg.getUserId() + ",用户名：" + msg.getUserName());
        UserHelper.setUserId(msg.getUserId());
        UserHelper.setUserName(msg.getUserName());

        //通知执行下一个handler
        ctx.fireChannelRead(msg);
    }
}
