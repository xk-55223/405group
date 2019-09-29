/*
package com.cskaoyan.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com..controller.*.*(..))")
    public void mypointcut(){}

    @Around("mypointcut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        System.out.println("before aspect");
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after aspect");
        return proceed;
    }
}
*/
