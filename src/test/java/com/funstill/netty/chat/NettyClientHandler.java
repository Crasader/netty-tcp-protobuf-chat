package com.funstill.netty.chat;

import com.funstill.netty.chat.protobuf.CommonMsg;
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
        ProtoMsg.Header.Builder headerBuilder= ProtoMsg.Header.newBuilder();
        headerBuilder.setLength(999);
        headerBuilder.setProtoType(1);
        CommonMsg.Body.Builder body= CommonMsg.Body.newBuilder();
        body.setContent("sss");
        ProtoMsg.Message.Builder  msgBuilder=ProtoMsg.Message.newBuilder();
        msgBuilder.setHeader(headerBuilder);
        msgBuilder.setBody(body.build().toByteString());


        ctx.writeAndFlush(msgBuilder.build());
    }
}
