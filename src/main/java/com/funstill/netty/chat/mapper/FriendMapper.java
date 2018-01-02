package com.funstill.netty.chat.mapper;

import com.funstill.netty.chat.model.user.ChatFriend;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendMapper {
	ChatFriend selectById(Long id);
	List<ChatFriend> selectByUserId(Long userId);
}
