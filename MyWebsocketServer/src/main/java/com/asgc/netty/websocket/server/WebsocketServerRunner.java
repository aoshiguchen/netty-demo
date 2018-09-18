package com.asgc.netty.websocket.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * netty服务监听器
 * Author: yangwen
 * Date:  2018/9/7
 */
@Component
public class WebsocketServerRunner  implements ApplicationRunner {

    @Autowired
    private WebsocketServer websocketServer;

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
            websocketServer.start();
        }

    }
}
