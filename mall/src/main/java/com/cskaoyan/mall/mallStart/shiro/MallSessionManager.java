package com.cskaoyan.mall.mallStart.shiro;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class MallSessionManager extends DefaultWebSessionManager {

    @Override
    protected Serializable getSessionId(ServletRequest servletRequest, ServletResponse response) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String header = request.getHeader("X-cskaoyanmall-Admin-Token");
        String header1 = request.getHeader("X-Litemall-Token");
        if (header != null && !"".equals(header.trim())) {
            return header;
        } else if (header1 != null && !"".equals(header1.trim())) {
            return header1;
        }
        return super.getSessionId(servletRequest, response);
    }
}
