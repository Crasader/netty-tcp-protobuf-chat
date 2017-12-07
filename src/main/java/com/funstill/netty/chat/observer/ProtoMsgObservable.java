package com.funstill.netty.chat.observer;

import com.funstill.netty.chat.model.ProtoTypeEnum;
import com.funstill.netty.chat.protobuf.CommonMsg;
import com.funstill.netty.chat.protobuf.ProtoMsg;
import com.google.protobuf.InvalidProtocolBufferException;
import io.netty.channel.Channel;

/**
 * @author liukaiyang
 * @date 2017/12/6 10:15
 */
public class ProtoMsgObservable extends BaseObservable{

    public void notifyObservers(Channel channel, ProtoMsg.Message msg) throws InvalidProtocolBufferException {
        Object[] arrLocal;
        synchronized (this) {
            if (!hasChanged())
                return;
            arrLocal = getObservers().toArray();
            clearChanged();
        }
        if (msg.getHeader().getProtoType() == ProtoTypeEnum.COMMON_MSG.getIndex()) {
            CommonMsg.Body commonMsg = CommonMsg.Body.parseFrom(msg.getBody());
            for (int i = arrLocal.length - 1; i >= 0; i--) {
                ((ProtoMsgObserver) arrLocal[i]).handleCommonMsg(channel, commonMsg);
            }
        } else if (msg.getHeader().getProtoType() == ProtoTypeEnum.LOGIN_MSG.getIndex()) {
            //TODO 登录处理
        }
    }
    public void handleMsg(Channel channel, ProtoMsg.Message msg) throws InvalidProtocolBufferException {
      setChanged();
      notifyObservers(channel,msg);
    }
}
