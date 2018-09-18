package com.asgc.netty.websocket.model;

/**
 * TODO
 * Author: yangwen
 * Date:  2018/9/10
 */
public class Message {

    private String content;

    public Message(){

    }

    public Message(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
