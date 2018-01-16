package com.funstill.netty.chat.server.observer;

import com.alibaba.fastjson.JSON;
import com.funstill.netty.chat.mapper.UserMapper;
import com.funstill.netty.chat.model.enums.ProtoTypeEnum;
import com.funstill.netty.chat.model.enums.ResponseEnum;
import com.funstill.netty.chat.model.user.ChatUser;
import com.funstill.netty.chat.protobuf.AuthMsg;
import com.funstill.netty.chat.protobuf.AuthResponseMsg;
import com.funstill.netty.chat.protobuf.CommonMsg;
import com.funstill.netty.chat.protobuf.ProtoMsg;
import com.funstill.netty.chat.server.processor.OnlineProcessor;
import io.netty.channel.Channel;
import io.netty.util.Attribute;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * 消息默认处理的类型<br/>
 * 备注:可以另外添加Observer扩展处理其他类型消息<br/>
 * 添加方法:待容器启动后,<code>NettyServerHandler.msgObservable.addObserver()</code>
 * @author liukaiyang
 * @date 2017/12/6 20:16
 */
@Service("protoMsgObserver")
public class DefaultProtoMsgObserver implements ProtoMsgObserver {
    private final static Logger logger = LogManager.getLogger(DefaultProtoMsgObserver.class);
    @Autowired
    private UserMapper userMapper;

    @Override
    public void handleProtoMsg(Channel channel, ProtoMsg.Content msg) {

        //消息id
        if (StringUtils.isEmpty(msg.getUuid())) {
            msg=msg.toBuilder().setUuid(UUID.randomUUID().toString()).build();
        }
        if (msg.getProtoType() == ProtoTypeEnum.LOGIN_REQUEST_MSG.getIndex()) {//登录请求
            //响应
            AuthResponseMsg.Content.Builder res = AuthResponseMsg.Content.newBuilder();
            try {
                AuthMsg.Content authMsg = AuthMsg.Content.parseFrom(msg.getContent());
                logger.debug("服务器收到登录请求:{}", authMsg.toString());
                ChatUser user = userMapper.selectByUsername(authMsg.getUsername());
                if (user == null) {
                    res.setCode(ResponseEnum.USER_NOT_EXIST.getCode());
                    res.setMsg(ResponseEnum.USER_NOT_EXIST.getMsg());
                } else if (!user.getPassword().equals(authMsg.getPassword())) {//密码不正确
                    res.setCode(ResponseEnum.ERROR_PASSWORD.getCode());
                    res.setMsg(ResponseEnum.ERROR_PASSWORD.getMsg());
                } else {
                    res.setCode(ResponseEnum.SUCCESS.getCode());
                    res.setMsg(ResponseEnum.SUCCESS.getMsg());
                    res.setUserId(user.getUserId() + "");
                    res.setExtra(JSON.toJSONString(user));
                    //登录成功
                    Attribute<String> attr = channel.attr(OnlineProcessor.ATTRIBUTE_KEY);
                    attr.setIfAbsent(user.getUserId() + "");
                    OnlineProcessor.getInstance().putUser(user.getUserId() + "", channel);
                }
                ProtoMsg.Content.Builder msgBuilder = msg.toBuilder();
                msgBuilder.setProtoType(ProtoTypeEnum.LOGIN_RESPONSE_MSG.getIndex());
                msgBuilder.setContent(res.build().toByteString());
                channel.writeAndFlush(msgBuilder.build());

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (msg.getProtoType() == ProtoTypeEnum.COMMON_MSG.getIndex()) {
            try {
                CommonMsg.Content commonMsg = CommonMsg.Content.parseFrom(msg.getContent());
                logger.debug("服务器收到聊天消息:{}", commonMsg.toString());
                //消息echo,主要是告诉客户端消息已被服务端接收处理并返回消息id
                ProtoMsg.Content.Builder msgBuilder = msg.toBuilder();
                msgBuilder.setProtoType(ProtoTypeEnum.COMMON_MSG_ECHO.getIndex());
                channel.writeAndFlush(msgBuilder.build());
                //转发消息
                boolean isReceiverOnline=OnlineProcessor.getInstance().isOnline(commonMsg.getReceiver()+"");
                if(isReceiverOnline){
                    Channel recChannel=OnlineProcessor.getInstance().getChannelMap().get(commonMsg.getReceiver()+"");
                    recChannel.writeAndFlush(msg);
                }else {
                    //TODO 离线消息处理
                }
            } catch (Exception e) {
                logger.error("处理消息异常:{}",e);
                e.printStackTrace();
            }


        }

    }
}
