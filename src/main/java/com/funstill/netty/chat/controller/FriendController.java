package com.funstill.netty.chat.controller;

import com.funstill.netty.chat.mapper.FriendMapper;
import com.funstill.netty.chat.model.user.ChatFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author liukaiyang
 * @date 2017/12/12 10:10
 */
@Controller
public class FriendController {
    @Autowired
    private FriendMapper friendMapper;
    @RequestMapping("/friend/list")
    @ResponseBody
    public List<ChatFriend> friendList(@RequestParam Long userId) {
        List<ChatFriend> friendList= friendMapper.selectByUserId(userId);
        return friendList;
    }

    @RequestMapping("/friend/detail")
    @ResponseBody
    public ChatFriend friendDetail(@RequestParam Long userId,@RequestParam Long friendId) {
        ChatFriend friend= friendMapper.selectByUserIdFriendId(userId,friendId);
        return friend;
    }
}
