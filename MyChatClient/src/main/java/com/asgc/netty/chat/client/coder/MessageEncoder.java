package com.asgc.netty.chat.client.coder;

import com.alibaba.fastjson.JSON;
import com.asgc.netty.chat.client.model.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 消息编码器
 * Author: yangwen
 * Date:  2018/9/6
 */
public class MessageEncoder extends MessageToMessageEncoder<Message> {

    private static final Logger logger = LoggerFactory.getLogger(MessageEncoder.class);

    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, List<Object> list) throws Exception {
        logger.info("MessageEncoder decode encode !");

        list.add(JSON.toJSON(msg) + "\n");

    }

}
