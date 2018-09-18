package com.asgc.netty.chat.client.model;

/**
 * 消息
 * Author: yangwen
 * Date:  2018/9/6
 */
public class Message{

    /**
     * 文本类型
     */
    public static final int TEXT = 1;

    /**
     * 图片类型
     */
    public static final int IMAGE = 2;

    /**
     * 用户上线
     */
    public static final int ONLINE = 3;

    /**
     * 用户下线
     */
    public static final int OFFLINE = 4;

    /**
     * 登陆消息
     */
    public static final int LOGIN = 5;

    /**
     * 系统消息标识
     */
    public static final int SYS_MSG_FLAG = 1;

    /**
     * 消息类型 (1:文本 2:图片)
     */
    private int type;

    /**
     * 消息来源id
     */
    private Integer fromId;

    /**
     * 消息来源名称
     */
    private String fromName;

    /**
     * 消息去向id
     */
    private Integer toId;

    /**
     * 消息去向名称
     */
    private String toName;

    /**
     * 系统消息标识
     */
    private int sysMsgFlag;

    public int getType() {
        return type;
    }

    public Integer getFromId() {
        return fromId;
    }

    public String getFromName() {
        return fromName;
    }

    public Integer getToId() {
        return toId;
    }

    public String getToName() {
        return toName;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public int getSysMsgFlag() {
        return sysMsgFlag;
    }

    public void setSysMsgFlag(int sysMsgFlag) {
        this.sysMsgFlag = sysMsgFlag;
        if(sysMsgFlag == Message.SYS_MSG_FLAG){
            this.setFromId(0);
        }
    }

}
