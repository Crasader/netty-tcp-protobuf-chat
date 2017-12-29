package com.funstill.netty.chat.mapper;

import com.funstill.netty.chat.model.user.ChatFriend;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendMapper {
	ChatFriend selectById(Long id);
	ChatFriend selectByUserId(Long userId);
}
