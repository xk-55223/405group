package com.cskaoyan.mall.mallStart.tool;

public class StringToArray {
    /*String的"[1,2,3]" 转化成int{1,2,3}*/
    public static int[] stringToIntArray(String stringParam) {
        String[] stringArray = stringParam.replace("[", "").replace("]", "").split(",");
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }
}
