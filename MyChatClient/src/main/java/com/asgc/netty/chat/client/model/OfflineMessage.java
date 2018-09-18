package com.asgc.netty.chat.client.model;

/**
 * 下线消息
 * Author: yangwen
 * Date:  2018/9/6
 */
public class OfflineMessage extends Message {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    public OfflineMessage(){
        this.setType(OFFLINE);
        this.setSysMsgFlag(SYS_MSG_FLAG);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
