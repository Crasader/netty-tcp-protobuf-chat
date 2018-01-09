package com.funstill.netty.chat.controller;

import com.funstill.netty.chat.mapper.UserMapper;
import com.funstill.netty.chat.model.user.ChatUser;
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
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/user/detail")
    @ResponseBody
    public ChatUser user(@RequestParam Long userId) {
        ChatUser user= userMapper.selectById(userId);
        return user;
    }
}
