package com.funstill.netty.chat.handler;


import com.funstill.netty.chat.model.ProtoTypeEnum;
import com.funstill.netty.chat.protobuf.CommonMsg;
import com.funstill.netty.chat.protobuf.ProtoMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyServerHandler extends SimpleChannelInboundHandler<ProtoMsg.Message> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ProtoMsg.Message msg) throws Exception {
//		Channel ch=ctx.channel();
		if(msg.getHeader().getProtoType()== ProtoTypeEnum.COMMON_MSG.getIndex()){
			CommonMsg.Body commonMsg=CommonMsg.Body.parseFrom(msg.getBody());
			System.out.println("server收到消息:" + commonMsg.toString());
		}
		// 回复一条信息给客户端(response)
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
