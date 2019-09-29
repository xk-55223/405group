package com.cskaoyan.mall.mallStart.config;


import com.cskaoyan.mall.mallStart.filter.HelloFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new HelloFilter());
        filterRegistrationBean.addUrlPatterns("/hello");
        return filterRegistrationBean;
    }
}
