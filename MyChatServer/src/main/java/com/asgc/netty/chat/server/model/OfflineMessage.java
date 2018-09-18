package com.asgc.netty.chat.server.model;

import com.asgc.netty.chat.server.util.ChatUtil;

/**
 * 下线消息
 * Author: yangwen
 * Date:  2018/9/6
 */
public class OfflineMessage extends Message{

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
        this.setUserName(ChatUtil.getUserNameById(userId));
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
