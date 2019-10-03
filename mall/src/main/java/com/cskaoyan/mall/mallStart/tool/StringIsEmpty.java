package com.cskaoyan.mall.mallStart.tool;

public class StringIsEmpty {
    public static boolean stringIsEmpty(String s){
        if(s == null | s.trim().equals("")){
            return true;
        }
        return false;
    }
}
