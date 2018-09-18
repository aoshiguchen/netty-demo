package com.asgc.netty.chat.client.util;

/**
 * 用户工具类
 * Author: yangwen
 * Date:  2018/9/7
 */
public class UserHelper {

    /**
     * 用户id
     */
    private static Integer userId;

    /**
     * 用户名
     */
    private static String userName;

    public static Integer getUserId() {
        return userId;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserId(Integer userId) {
        UserHelper.userId = userId;
    }

    public static void setUserName(String userName) {
        UserHelper.userName = userName;
    }
}
