package com.funstill.netty.chat.mapper;

import com.funstill.netty.chat.model.user.ChatFriend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendMapper {
	ChatFriend selectById(Long id);
	ChatFriend selectByUserIdFriendId(@Param("userId") Long userId,@Param("friendId") Long friendId);
	List<ChatFriend> selectByUserId(Long userId);
}
