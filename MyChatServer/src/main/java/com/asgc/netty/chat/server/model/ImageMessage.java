package com.asgc.netty.chat.server.model;

/**
 * 图片消息
 * Author: yangwen
 * Date:  2018/9/6
 */
public class ImageMessage extends Message{

    /**
     * 图片url
     */
    private String url;

    /**
     * 图片描述
     */
    private String desc;

    public ImageMessage(){
        this.setType(Message.IMAGE);
    }

    public String getUrl() {
        return url;
    }

    public String getDesc() {
        return desc;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}


