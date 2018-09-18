package com.asgc.netty.chat.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * netty配置
 * Author: yangwen
 * Date:  2018/9/5
 */
@Component
@ConfigurationProperties(prefix="netty")
public class NettyConfig {

    /**
     * 端口号
     */
    private int port;

    /**
     * boss线程数量
     */
    private int bossThreadCount;

    /**
     * work线程数量
     */
    private int workThreadCount;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getBossThreadCount() {
        return bossThreadCount;
    }

    public int getWorkThreadCount() {
        return workThreadCount;
    }

    public void setBossThreadCount(int bossThreadCount) {
        this.bossThreadCount = bossThreadCount;
    }

    public void setWorkThreadCount(int workThreadCount) {
        this.workThreadCount = workThreadCount;
    }
}
