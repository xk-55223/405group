package com.cskaoyan.mall.mallStart.tool;

public class OrderStatus {
    public static String getString(short statusId){
        String s = null;
        switch (statusId){
            case 101: s = "未付款";break;
            case 102: s =  "用户取消";break;
            case 103: s = "系统取消";break;
            case 201: s = "已付款";break;
            case 202: s = "申请退款";break;
            case 203: s = "已退款";break;
            case 301: s = "已发货";break;
            case 401: s = "用户收货";break;
            case 402: s = "系统收货";break;
        }
        return s;
    }
}
