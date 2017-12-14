package com.funstill.netty.chat.observer;

import com.funstill.netty.chat.protobuf.ProtoMsg;
import io.netty.channel.Channel;

/**
 * @author liukaiyang
 * @date 2017/12/6 10:15
 */
public interface ProtoMsgObserver{
    /**
     * 处理普通消息(文本,图片,等)
     *
     * @param channel 客户端连接channel
     * @param msg
     */
    void handleCommonMsg(Channel channel,ProtoMsg.Content msg);

    /**
     * 处理登录,验证密码
     * @param channel
     */
    void handleLogin(Channel channel);
}
