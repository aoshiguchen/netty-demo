package com.asgc.netty.chat.server.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * netty服务监听器
 * Author: yangwen
 * Date:  2018/9/5
 */
@Component
public class ChatServerRunner implements ApplicationRunner {

    @Autowired
    private ChatServer chatServer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Thread thread = new Thread(new ChatServerThread());
        thread.start();
    }

    /**
     * netty服务启动线程
     */
    private class ChatServerThread implements Runnable{

        @Override
        public void run() {
            chatServer.start();
        }

    }

}


