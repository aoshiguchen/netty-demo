package com.asgc.netty.websocket.server;

import com.asgc.netty.websocket.config.NettyConfig;
import com.asgc.netty.websocket.handler.WebSocketChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * websocket服务
 * Author: yangwen
 * Date:  2018/9/7
 */
@Component
public class WebsocketServer {

    private static final Logger logger = LoggerFactory.getLogger(WebsocketServer.class);

    /**
     * netty配置
     */
    @Autowired
    private NettyConfig nettyConfig;

    /**
     * bootstrap
     */
    ServerBootstrap serverBootstrap;

    /**
     * boss
     */
    private EventLoopGroup boss;

    /**
     * work
     */
    private EventLoopGroup work;

    /**
     * 启动服务
     */
    public void start(){
        //获取netty配置
        int port = nettyConfig.getPort();
        int bossThreadCount = nettyConfig.getBossThreadCount();
        int workThreadCount = nettyConfig.getWorkThreadCount();

        try{
            serverBootstrap = new ServerBootstrap();
            boss = new NioEventLoopGroup(bossThreadCount);
            work = new NioEventLoopGroup(workThreadCount);

            serverBootstrap.group(boss,work).channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new WebSocketChannelInitializer());

            logger.info("启动服务，端口号：" + port);

            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            channelFuture.channel().closeFuture().sync();

        }catch (Exception e){
            logger.error("服务异常",e);
        }finally {
            this.close();
        }

    }

    /**
     * 关闭服务
     */
    public void close(){
        logger.info("关闭服务");
        boss.shutdownGracefully();
        work.shutdownGracefully();
    }

}
