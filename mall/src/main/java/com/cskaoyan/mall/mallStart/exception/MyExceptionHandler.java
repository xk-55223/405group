package com.cskaoyan.mall.mallStart.exception;

import com.cskaoyan.mall.mallStart.bean.BaseRespVo;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler({MethodArgumentTypeMismatchException.class,
            HttpMessageNotReadableException.class})
    @ResponseBody
   public BaseRespVo authorizationExceptionHandler(){
        return BaseRespVo.fail("兄弟，请输入正确数字");
    }
}
