package com.funstill.netty.chat.observer;

import com.funstill.netty.chat.protobuf.CommonMsg;
import io.netty.channel.Channel;

/**
 * @author liukaiyang
 * @date 2017/12/6 20:16
 */
public class ProtoMsgObserverImpl implements ProtoMsgObserver {
    @Override
    public void handleCommonMsg(Channel channel, CommonMsg.Body msg) {
        System.out.println(msg.getContent());
    }

    @Override
    public void handleLogin(Channel channel) {

    }

}
