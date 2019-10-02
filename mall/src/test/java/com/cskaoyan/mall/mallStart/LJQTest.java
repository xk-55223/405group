package com.cskaoyan.mall.mallStart;

import org.junit.Test;

import java.util.Arrays;
import java.util.UUID;

public class LJQTest {
    @Test
    public void myTest(){
        String originalFilename="兰嘉琪sad阿萨德.jpg";
        String[] split = originalFilename.split("\\.");
        String key = UUID.randomUUID().toString().replaceAll("-", "") + "." + split[split.length-1];
        System.out.println(key);
    }
}
