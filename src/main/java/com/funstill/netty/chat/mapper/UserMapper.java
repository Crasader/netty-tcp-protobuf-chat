package com.funstill.netty.chat.mapper;

import com.funstill.netty.chat.model.user.ChatUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	ChatUser selectById(Long id);
	ChatUser selectByUsername(String username);
}
