package com.cskaoyan.mall.mallStart.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UserLoginInfo {
    private Serializable token;
    private LocalDateTime tokenExpire;
    private WxUser userInfo;

    public Serializable getToken() {
        return token;
    }

    public void setToken(Serializable token) {
        this.token = token;
    }

    public LocalDateTime getTokenExpire() {
        return tokenExpire;
    }

    public void setTokenExpire(LocalDateTime tokenExpire) {
        this.tokenExpire = tokenExpire;
    }

    public WxUser getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(WxUser userInfo) {
        this.userInfo = userInfo;
    }
}
