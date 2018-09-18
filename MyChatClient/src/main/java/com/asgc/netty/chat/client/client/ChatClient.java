package com.asgc.netty.chat.client.client;

import com.asgc.netty.chat.client.config.NettyConfig;
import com.asgc.netty.chat.client.handler.ChatClientInitializer;
import com.asgc.netty.chat.client.model.TextMessage;
import com.asgc.netty.chat.client.util.UserHelper;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 聊天室客户端
 * Author: yangwen
 * Date:  2018/9/5
 */
@Component
public class ChatClient {

    private static final Logger logger = LoggerFactory.getLogger(ChatClient.class);

    /**
     * netty配置
     */
    @Autowired
    private NettyConfig nettyConfig;

    /**
     * bootstrap
     */
    Bootstrap bootstrap;

    /**
     * boss
     */
    private EventLoopGroup eventLoopGroup;

    /**
     * 启动客户端
     */
    public void start(){
        //获取netty配置
        int port = nettyConfig.getPort();

        try{
            bootstrap = new Bootstrap();
            eventLoopGroup = new NioEventLoopGroup();

            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .handler(new ChatClientInitializer());

            logger.info("连接服务端,端口号：" + port);

            Channel channel = bootstrap.connect("localhost", port).sync().channel();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            for (; ;) {
                Integer toId = Integer.valueOf(br.readLine());
                String content = br.readLine();

                TextMessage msg = new TextMessage();
                msg.setFromId(UserHelper.getUserId());
                msg.setToId(toId);
                msg.setContent(content);
                channel.writeAndFlush(msg);

                System.out.println("【自己】：" + msg.getContent());
            }

        }catch (Exception e){
            logger.error("客户端异常",e);
        }finally {
            this.close();
        }
    }

    /**
     * 关闭客户端
     */
    public void close(){
        logger.info("关闭客户端");
        eventLoopGroup.shutdownGracefully();
    }

}
