package com.funstill.netty.chat.observer;

import com.funstill.netty.chat.model.enums.ProtoTypeEnum;
import com.funstill.netty.chat.model.enums.ResponseEnum;
import com.funstill.netty.chat.protobuf.AuthMsg;
import com.funstill.netty.chat.protobuf.AuthResponseMsg;
import com.funstill.netty.chat.protobuf.CommonMsg;
import com.funstill.netty.chat.protobuf.ProtoMsg;
import com.funstill.netty.chat.mapper.UserMapper;
import com.funstill.netty.chat.model.user.ChatUser;
import com.google.protobuf.InvalidProtocolBufferException;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * 通用处理
 *
 * @author liukaiyang
 * @date 2017/12/6 20:16
 */
@Service("protoMsgObserver")
public class DefaultProtoMsgObserver implements ProtoMsgObserver {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void handleProtoMsg(Channel channel, ProtoMsg.Content msg) {
        //消息id
        if (StringUtils.isEmpty(msg.getUuid())) {
            msg.toBuilder().setUuid(UUID.randomUUID().toString());
        }
        if (msg.getProtoType() == ProtoTypeEnum.LOGIN_MSG.getIndex()) {//登录请求
            //响应
            AuthResponseMsg.Content.Builder res = AuthResponseMsg.Content.newBuilder();

            try {
                AuthMsg.Content authMsg = AuthMsg.Content.parseFrom(msg.getContent());
                ChatUser user = userMapper.selectByUsername(authMsg.getUsername());
                if(user==null){
                    res.setCode(ResponseEnum.USER_NOT_EXIST.getCode());
                    res.setMsg(ResponseEnum.USER_NOT_EXIST.getMsg());
                }else if(!user.getPassword().equals(authMsg.getPassword())){//密码不正确
                    res.setCode(ResponseEnum.ERROR_PASSWORD.getCode());
                    res.setMsg(ResponseEnum.ERROR_PASSWORD.getMsg());
                }else {
                    res.setCode(ResponseEnum.SUCCESS.getCode());
                    res.setMsg(ResponseEnum.SUCCESS.getMsg());
                    res.setUserId(user.getUserId()+"");
                }
                ProtoMsg.Content.Builder msgBuilder=msg.toBuilder();
                msgBuilder.setProtoType(ProtoTypeEnum.LOGIN_RES_MSG.getIndex());
                msgBuilder.setContent(res.build().toByteString());
                channel.writeAndFlush(msgBuilder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (msg.getProtoType() == ProtoTypeEnum.COMMON_MSG.getIndex()) {//普通聊天信息
            CommonMsg.Content commonMsg = null;
            try {
                commonMsg = CommonMsg.Content.parseFrom(msg.getContent());
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
            System.out.println(commonMsg.getContent());
            //测试代码

        }

    }
}
