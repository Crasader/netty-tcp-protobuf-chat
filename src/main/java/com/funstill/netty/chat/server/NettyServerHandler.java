package com.funstill.netty.chat.server;


import com.funstill.netty.chat.protobuf.ProtoMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

public class NettyServerHandler extends SimpleChannelInboundHandler<ProtoMsg.Message> {

	ChannelGroup c;
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ProtoMsg.Message msg) throws Exception {
//		Channel ch=ctx.channel();
		System.out.println("server收到消息:" + msg.toString());
		// 回复一条信息给客户端
//		ctx.writeAndFlush(reply);

	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("server已激活"+ctx.channel().remoteAddress());
	}
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("server已停止"+ctx.channel().remoteAddress());
	}

}
