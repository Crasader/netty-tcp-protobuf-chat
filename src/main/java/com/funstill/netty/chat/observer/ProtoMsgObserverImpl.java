package com.funstill.netty.chat.observer;

import com.funstill.netty.chat.protobuf.CommonMsg;
import com.funstill.netty.chat.protobuf.ProtoMsg;
import com.google.protobuf.InvalidProtocolBufferException;
import io.netty.channel.Channel;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author liukaiyang
 * @date 2017/12/6 20:16
 */
public class ProtoMsgObserverImpl implements ProtoMsgObserver {
    @Override
    public void handleCommonMsg(Channel channel, ProtoMsg.Content msg) {
        CommonMsg.Content commonMsg = null;
        try {
            commonMsg = CommonMsg.Content.parseFrom(msg.getContent());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        //消息id
        if (StringUtils.isEmpty(msg.getUuid())) {
            msg.toBuilder().setUuid(UUID.randomUUID().toString());
        }
        System.out.println(commonMsg.getContent());
        channel.writeAndFlush(msg);
    }

    @Override
    public void handleLogin(Channel channel) {

    }

}
