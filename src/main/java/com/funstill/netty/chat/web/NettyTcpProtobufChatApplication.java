package com.funstill.netty.chat.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.funstill.netty.chat.web.mybatis.mapper")
public class NettyTcpProtobufChatApplication {
	public static void main(String[] args) {
		SpringApplication.run(NettyTcpProtobufChatApplication.class, args);
	}
}
