package com.funstill.netty.chat.web.mybatis.mapper;

import com.funstill.netty.chat.web.mybatis.model.ChatUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	ChatUser selectById(Long id);
}
