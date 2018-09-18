package com.asgc.netty.websocket.coder;

import com.alibaba.fastjson.JSONObject;
import com.asgc.netty.websocket.model.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 消息解码器
 * Author: yangwen
 * Date:  2018/9/6
 */
public class MessageDecoder extends MessageToMessageDecoder<TextWebSocketFrame> {

    private static final Logger logger = LoggerFactory.getLogger(MessageDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext ctx, TextWebSocketFrame msg, List<Object> list) throws Exception {
        logger.info("MessageDecoder decode invoked !");

        try{
            Message message = JSONObject.parseObject(msg.text(),Message.class);

            list.add(message);

        }catch (Exception e){
            logger.error("消息:" + msg.text() + " 格式异常!",e);
        }

    }
}
