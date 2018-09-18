package com.asgc.netty.chat.client.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * TODO
 * Author: yangwen
 * Date:  2018/9/5
 */
@Component
public class ChatClientRunner  implements ApplicationRunner {

    @Autowired
    private ChatClient chatClient;

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
            chatClient.start();
        }

    }

}
