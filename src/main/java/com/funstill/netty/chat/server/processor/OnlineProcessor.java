package com.funstill.netty.chat.server.processor;

import io.netty.channel.Channel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ConcurrentHashMap;

public class OnlineProcessor {
    //登录的唯一标识,暂用userId
    public static final AttributeKey<String> ATTRIBUTE_KEY = AttributeKey.valueOf("unique_identity");
    private static Logger logger = LogManager.getLogger(OnlineProcessor.class);
    private static OnlineProcessor instance = null;
    private ConcurrentHashMap<String, Channel> channelMap = new ConcurrentHashMap<>();

    private OnlineProcessor() {
    }

    public static OnlineProcessor getInstance() {
        if (instance == null)
            instance = new OnlineProcessor();
        return instance;
    }


    public void putUser(String userId, Channel channel) {
        if (channelMap.containsKey(channel)) {
            boolean sameChannel=channelMap.get(userId).hashCode() == channel.hashCode();
            logger.debug("用户id={}已经在在线列表中了，channel也是同一个吗？{}", userId, sameChannel);
            //TODO 踢出
        }else {
            channelMap.put(userId, channel);
        }
        logger.debug("当前在线用户共({})人", channelMap.size());
    }

    public boolean removeUser(String userId) {
        synchronized (channelMap) {
            if (!channelMap.containsKey(userId)) {
                logger.debug("用户id={}不存在在线列表中，本次removeUser没有继续", userId);
                return false;
            } else {
                Channel channel = channelMap.remove(userId);
                boolean result=channel != null;
                if (result) {
                    logger.debug("用户id={}已成功下线", userId);
                }
                return result;
            }
        }
    }

    public ConcurrentHashMap<String, Channel> getChannelMap() {
        return channelMap;
    }

    public static String getUniqueIdentityFromChannel(Channel channel) {
        if (channel != null) {
            Attribute<String> attr = channel.attr(ATTRIBUTE_KEY);
            if (attr != null)
                return attr.get();
        }
        return null;
    }

    /**
     * 检测用户是否在线
     *
     * @param userId
     * @return
     */
    public static boolean isOnline(String userId) {
        Channel channel = OnlineProcessor.getInstance().channelMap.get(userId);
        return channel != null && channel.isActive();
    }

    public static boolean isOnline(Channel channel) {
        return channel != null && channel.isActive() && getUniqueIdentityFromChannel(channel) != null;
    }
}
