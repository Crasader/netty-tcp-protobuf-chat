package com.funstill.netty.chat.model.user;

import java.util.Date;

/**
 * @author liukaiyang
 * @date 2017/12/28 16:52
 */
public class ChatFriend {
    private Long id;
    private Long userId;
    private Long friendUserId;
    /**
     * 备注名
     */
    private String friendNoteName;
//    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createDate;
    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFriendUserId() {
        return friendUserId;
    }

    public void setFriendUserId(Long friendUserId) {
        this.friendUserId = friendUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getFriendNoteName() {
        return friendNoteName;
    }

    public void setFriendNoteName(String friendNoteName) {
        this.friendNoteName = friendNoteName;
    }
}
