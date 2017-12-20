package com.funstill.netty.chat.server;


import com.funstill.netty.chat.observer.ProtoMsgObservable;
import com.funstill.netty.chat.observer.ProtoMsgObserver;
import com.funstill.netty.chat.protobuf.ProtoMsg;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NettyServerHandler extends SimpleChannelInboundHandler<ProtoMsg.Content> implements InitializingBean {
    @Autowired
    private ProtoMsgObserver protoMsgObserver;
    Logger logger = LogManager.getLogger(NettyServerHandler.class);
    public static ProtoMsgObservable msgObservable = new ProtoMsgObservable();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ProtoMsg.Content msg) throws Exception {
        Channel ch = ctx.channel();
        logger.info("准备接收消息-客户端ip:{}", ch.remoteAddress());
        msgObservable.handleMsg(ch, msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("server已激活");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("server已停止");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        msgObservable.addObserver(protoMsgObserver);
    }
}