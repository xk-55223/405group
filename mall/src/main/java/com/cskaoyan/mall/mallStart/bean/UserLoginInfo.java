package com.cskaoyan.mall.mallStart.bean;

public class UserLoginInfo {
    private String token;
    private String tokenExpire;
    private WxUser userInfo;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenExpire() {
        return tokenExpire;
    }

    public void setTokenExpire(String tokenExpire) {
        this.tokenExpire = tokenExpire;
    }

    public WxUser getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(WxUser userInfo) {
        this.userInfo = userInfo;
    }
}
