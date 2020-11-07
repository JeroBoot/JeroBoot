package com.jero.web.core.config;

import com.jero.web.core.filter.CorsFilter;
import com.jero.web.core.filter.HttpCacheFilter;
import com.jero.web.core.filter.RequestInfoFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 过滤器配置器
 * @Author zero
 * @Date 2020/3/24
 **/
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter(){
        FilterRegistrationBean<CorsFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new CorsFilter());
        registration.addUrlPatterns("/*");
        registration.setName("corsFilter");
        registration.setOrder(1);

        return registration;
    }

    @Bean
    public FilterRegistrationBean<HttpCacheFilter> httpCacheFilter(){
        FilterRegistrationBean<HttpCacheFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new HttpCacheFilter());
        registration.addUrlPatterns("/*");
        registration.setName("httpCacheFilter");
        registration.setOrder(2);

        return registration;
    }



    @Bean
    public FilterRegistrationBean<RequestInfoFilter> requestInfoFilter(){
        FilterRegistrationBean<RequestInfoFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new RequestInfoFilter());
        registration.addUrlPatterns("/*");
        registration.setName("requestInfoFilter");
        registration.setOrder(20);

        return registration;
    }



}
