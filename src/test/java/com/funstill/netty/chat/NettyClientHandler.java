package com.funstill.netty.chat;

import com.funstill.netty.chat.protobuf.ProtoMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author liukaiyang
 * @date 2017/12/5 15:04
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ctx.writeAndFlush(Unpooled.copiedBuffer("Hello，我是client", CharsetUtil.UTF_8));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ProtoMsg.Content pm = (ProtoMsg.Content) msg;
        System.out.println("客户端接收消息" + pm.getContent().toString());
    }

}
