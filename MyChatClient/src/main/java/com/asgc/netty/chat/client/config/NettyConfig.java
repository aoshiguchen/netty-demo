package com.asgc.netty.chat.client.config;

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


    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
