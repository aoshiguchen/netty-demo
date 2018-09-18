package com.asgc.netty.chat.server.handler;

import com.asgc.netty.chat.server.model.Message;
import com.asgc.netty.chat.server.model.OfflineMessage;
import com.asgc.netty.chat.server.util.ChatUtil;
import io.netty.channel.Channel;
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
        msg.setFromName(ChatUtil.getUserNameById(msg.getFromId()));
        logger.info(msg.getFromName() + " 发送了一条消息，消息类型：" + msg.getType());

//        ChatUtil.sendMsg(msg);
        Channel to = ChatUtil.getChannelById(msg.getToId());

        if(to == null){
            OfflineMessage offlineMessage = new OfflineMessage();
            offlineMessage.setUserId(msg.getToId());
            offlineMessage.setToId(msg.getFromId());

            ctx.channel().writeAndFlush(offlineMessage);
        }else{
            to.writeAndFlush(msg);
        }

        //通知执行下一个handler
        ctx.fireChannelRead(msg);
    }

}
