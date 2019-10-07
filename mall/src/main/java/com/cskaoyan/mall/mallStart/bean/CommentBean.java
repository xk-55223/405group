package com.cskaoyan.mall.mallStart.bean;

import java.util.Arrays;

public class CommentBean {
    @Override
    public String toString() {
        return "CommentBean{" +
                "addTime='" + addTime + '\'' +
                ", avatar='" + avatar + '\'' +
                ", content='" + content + '\'' +
                ", id=" + id +
                ", nickname='" + nickname + '\'' +
                ", picList=" + Arrays.toString(picList) +
                '}';
    }

    private String addTime;
    private String avatar;
    private String content;
    private int id;
    private String nickname;
    private String[] picList;

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String[] getPicList() {
        return picList;
    }

    public void setPicList(String[] picList) {
        this.picList = picList;
    }
}
