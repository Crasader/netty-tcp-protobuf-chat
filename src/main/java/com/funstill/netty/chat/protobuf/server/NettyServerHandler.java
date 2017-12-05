package com.funstill.netty.chat.protobuf.server;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.util.CharsetUtil;

public class NettyServerHandler extends SimpleChannelInboundHandler {

	ChannelGroup c;
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//		Channel ch=ctx.channel();
		ByteBuf buf=(ByteBuf)msg;
		System.out.println("server收到消息:" + buf.toString(CharsetUtil.UTF_8));
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
