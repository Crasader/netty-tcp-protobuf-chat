package com.funstill.netty.chat.controller;

import com.funstill.netty.chat.mapper.FriendMapper;
import com.funstill.netty.chat.model.user.ChatFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liukaiyang
 * @date 2017/12/12 10:10
 */
@Controller
public class FriendController {
    @Autowired
    private FriendMapper friendMapper;
    @RequestMapping("/friend")
    @ResponseBody
    public ChatFriend auth(@RequestParam Long userId) {
        ChatFriend friend= friendMapper.selectByUserId(userId);
        return friend;
    }
}
