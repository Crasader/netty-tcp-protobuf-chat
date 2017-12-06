package com.funstill.netty.chat.server;

import com.funstill.netty.chat.handler.NettyServerHandler;
import com.funstill.netty.chat.protobuf.ProtoMsg;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;

/**
 * @author liukaiyang
 * @date 2017/12/6 9:32
 */
public class NettyServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new ProtobufVarint32FrameDecoder());
        socketChannel.pipeline().addLast(new ProtobufDecoder(ProtoMsg.Message.getDefaultInstance()));
        socketChannel.pipeline().addLast(new NettyServerHandler());
    }
}
