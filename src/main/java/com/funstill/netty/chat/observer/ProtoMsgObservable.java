package com.funstill.netty.chat.observer;

import com.funstill.netty.chat.model.ProtoTypeEnum;
import com.funstill.netty.chat.protobuf.ProtoMsg;
import com.google.protobuf.InvalidProtocolBufferException;
import io.netty.channel.Channel;

/**
 * @author liukaiyang
 * @date 2017/12/6 10:15
 */
public class ProtoMsgObservable extends BaseObservable{

    public void notifyObservers(Channel channel, ProtoMsg.Content msg) throws InvalidProtocolBufferException {
        Object[] arrLocal;
        synchronized (this) {
            if (!hasChanged())
                return;
            arrLocal = getObservers().toArray();
            clearChanged();
        }
        if (msg.getProtoType() == ProtoTypeEnum.COMMON_MSG.getIndex()) {
            for (int i = arrLocal.length - 1; i >= 0; i--) {
                ((ProtoMsgObserver) arrLocal[i]).handleCommonMsg(channel, msg);
            }
        } else if (msg.getProtoType() == ProtoTypeEnum.LOGIN_MSG.getIndex()) {
            //TODO 登录处理
        }
    }
    public void handleMsg(Channel channel, ProtoMsg.Content msg) throws InvalidProtocolBufferException {
      setChanged();
      notifyObservers(channel,msg);
    }
}
