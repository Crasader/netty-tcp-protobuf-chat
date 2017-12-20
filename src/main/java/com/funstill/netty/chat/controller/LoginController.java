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
public class LoginController {
    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/auth")
    @ResponseBody
    public String auth(@RequestParam String username,
                       @RequestParam String password) {
        ChatUser user= userMapper.selectById(1L);
        return user.getUsername();
    }
}
