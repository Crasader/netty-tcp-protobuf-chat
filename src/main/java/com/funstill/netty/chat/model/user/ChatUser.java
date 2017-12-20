package com.funstill.netty.chat.model.user;

/**
 * @author liukaiyang
 * @date 2017/12/12 15:42
 */
public class ChatUser {
    private String username;
    private String password;
    private Long userId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
