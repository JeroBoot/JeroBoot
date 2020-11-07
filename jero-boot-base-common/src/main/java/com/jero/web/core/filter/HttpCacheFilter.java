package com.jero.web.core.filter;

import com.jero.web.core.filter.wrapper.ExpiresHeaderResponse;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description Http缓存过滤器
 * @Author zero
 * @Date 2020/3/24
 **/
public class HttpCacheFilter implements Filter {

    private long maxAge = 60L * 60 * 24; //一天

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String maxAgeStr = filterConfig.getInitParameter("maxAge");
        if (StringUtils.isNotEmpty(maxAgeStr)) {
            maxAge = Long.valueOf(maxAgeStr);
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.reset();
        filterChain.doFilter(request, new ExpiresHeaderResponse(response, maxAge));
    }

}
