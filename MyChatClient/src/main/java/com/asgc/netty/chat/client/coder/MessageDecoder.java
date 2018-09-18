package com.asgc.netty.chat.client.coder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.asgc.netty.chat.client.model.*;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 消息解码器
 * Author: yangwen
 * Date:  2018/9/6
 */
public class MessageDecoder extends MessageToMessageDecoder<String> {

    private static final Logger logger = LoggerFactory.getLogger(MessageDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext ctx, String s, List<Object> list) throws Exception {
        logger.info("MessageDecoder decode invoked !");

        try{
            JSONObject jsonObject = JSON.parseObject(s);
            int msgType = jsonObject.getIntValue("type");

            Object msg = null;
            if(msgType == Message.TEXT){
                msg = JSON.parseObject(s,TextMessage.class);
            }else if(msgType == Message.IMAGE){
                msg = JSON.parseObject(s,ImageMessage.class);
            }else if(msgType == Message.ONLINE){
                msg = JSON.parseObject(s,OnlineMessage.class);
            }else if(msgType == Message.OFFLINE){
                msg = JSON.parseObject(s,OfflineMessage.class);
            }else if(msgType == Message.LOGIN){
                msg = JSON.parseObject(s,LoginMessage.class);
            }else {
                logger.error("消息:" + s + " 未知的类型!");
            }

            list.add(msg);

        }catch (Exception e){
            logger.error("消息:" + s + " 格式异常!",e);
        }

    }
}
