package com.funstill.netty.chat;

import com.funstill.netty.chat.server.NettyServerStarter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.funstill.netty.chat.mapper")
public class NettyTcpProtobufChatApplication implements ApplicationRunner{
	public static void main(String[] args) {
		SpringApplication.run(NettyTcpProtobufChatApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		System.out.println("初始化...");
		new NettyServerStarter().run();
	}
}
