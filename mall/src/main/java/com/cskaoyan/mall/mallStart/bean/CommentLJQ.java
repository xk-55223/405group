package com.cskaoyan.mall.mallStart.bean;

import com.cskaoyan.mall.mallStart.tool.UserInfo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CommentLJQ {
    private UserInfo userInfo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;

    private String[] picList;

    private String content;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String[] getPicList() {
        return picList;
    }

    public void setPicList(String[] picList) {
        this.picList = picList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
