package com.asgc.netty.chat.server.handler;

import com.asgc.netty.chat.server.model.LoginMessage;
import com.asgc.netty.chat.server.model.OfflineMessage;
import com.asgc.netty.chat.server.model.OnlineMessage;
import com.asgc.netty.chat.server.util.ChatUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息处理器
 * Author: yangwen
 * Date:  2018/9/5
 */
public class ChatServerHandler  extends SimpleChannelInboundHandler<String> {

    private static final Logger logger = LoggerFactory.getLogger(ChatServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();

        logger.info(channel.remoteAddress() + " 发送的消息：" + msg + "\n");

        //通知执行下一个handler
        ctx.fireChannelRead(msg);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        ChatUtil.addChannel(channel);

        OnlineMessage msg = new OnlineMessage();
        msg.setUserId(ChatUtil.getIdByChannel(channel));
        ChatUtil.channelGroup.forEach(ch -> {
            if(ch != channel) ch.writeAndFlush(msg);
        });

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        OfflineMessage msg = new OfflineMessage();
        msg.setUserId(ChatUtil.getIdByChannel(channel));
        ChatUtil.channelGroup.forEach(ch -> {
            if(ch != channel) ch.writeAndFlush(msg);
        });

        ChatUtil.removeChannel(channel);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        LoginMessage msg = new LoginMessage();
        msg.setUserId(ChatUtil.getIdByChannel(channel));

        channel.writeAndFlush(msg);

        logger.info(ChatUtil.getUserNameById(ChatUtil.getIdByChannel(channel)) + " 上线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        logger.info(ChatUtil.getUserNameById(ChatUtil.getIdByChannel(channel)) + " 下线");
    }


}
