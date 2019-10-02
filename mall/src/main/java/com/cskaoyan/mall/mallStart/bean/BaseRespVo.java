package com.cskaoyan.mall.mallStart.bean;

public class BaseRespVo<T> {
    private int errno;
    private T data;
    private String errmsg;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public static BaseRespVo ok(Object data) {
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setErrmsg("成功");
        objectBaseRespVo.setData(data);
        return objectBaseRespVo;
    }

    public static BaseRespVo fail(String message) {
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setErrmsg(message);
        objectBaseRespVo.setErrno(1);
        return objectBaseRespVo;
    }

}
