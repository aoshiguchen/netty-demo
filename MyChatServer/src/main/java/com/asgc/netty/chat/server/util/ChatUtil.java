package com.asgc.netty.chat.server.util;

import com.asgc.netty.chat.server.model.Message;
import com.asgc.netty.chat.server.model.OfflineMessage;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 聊天工具
 * Author: yangwen
 * Date:  2018/9/6
 */
public class ChatUtil {

    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    private static Map<Integer,Channel> idChannelMap = new ConcurrentHashMap<>();

    private static Map<Channel,Integer> channelIdMap = new ConcurrentHashMap<>();

    /**
     * id生成器
     */
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * id昵称映射
     */
    private static Map<Integer,String> idNameMap = new ConcurrentHashMap<>();

    static{
        idNameMap.put(0,"系统");
        idNameMap.put(1,"张三");
        idNameMap.put(2,"李四");
        idNameMap.put(3,"王五");
        idNameMap.put(4,"赵六");
        idNameMap.put(5,"刘七");
        idNameMap.put(6,"李八");
    }

    /**
     * 根据channel获取id
     * @param channel
     * @return
     */
    public static Integer getIdByChannel(Channel channel){
        return channelIdMap.get(channel);
    }

    /**
     * 根据id获取channel
     * @param id
     * @return
     */
    public static Channel getChannelById(Integer id){
        return idChannelMap.get(id);
    }

    /**
     * 添加channel
     * @param channel
     */
    public static void addChannel(Channel channel){
        Integer id = generatorId();
        idChannelMap.put(id,channel);
        channelIdMap.put(channel,id);
        channelGroup.add(channel);
    }

    /**
     * 删除channel
     * @param channel
     */
    public static void removeChannel(Channel channel){
        Integer id = getIdByChannel(channel);
        idChannelMap.remove(id);
        channelIdMap.remove(channel);
        channelGroup.remove(channel);
    }

    /**
     * 生成id
     * @return
     */
    private static Integer generatorId(){
        return atomicInteger.incrementAndGet();
    }

    /**
     * 根据id获取昵称
     * @param id
     * @return
     */
    public static String getUserNameById(Integer id){
        return idNameMap.get(id);
    }

}
