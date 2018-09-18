package com.asgc.netty.chat.client.model;

/**
 * 登陆消息
 * Author: yangwen
 * Date:  2018/9/7
 */
public class LoginMessage extends Message{

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    public LoginMessage(){
        this.setType(Message.LOGIN);
        this.setSysMsgFlag(SYS_MSG_FLAG);
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
