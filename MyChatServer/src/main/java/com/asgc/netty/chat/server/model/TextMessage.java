package com.asgc.netty.chat.server.model;

/**
 * 文本消息
 * Author: yangwen
 * Date:  2018/9/6
 */
public class TextMessage extends Message{

    private String content;

    public TextMessage(){
        this.setType(Message.TEXT);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
