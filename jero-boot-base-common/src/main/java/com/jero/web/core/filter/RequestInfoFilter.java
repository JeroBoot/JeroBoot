package com.jero.web.core.filter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请求响应时间filer
 *
 * @author zer0
 * @version 1.0
 */
public class RequestInfoFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestInfoFilter.class);

    private static final List<String> ignoreList = new ArrayList<String>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ignoreList.add("js");
        ignoreList.add("css");
        ignoreList.add("png");
        ignoreList.add("ico");
        ignoreList.add("gif");
        ignoreList.add("jpg");
        ignoreList.add("txt");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try {
            long startTime = System.currentTimeMillis();
            String uri = request.getServletPath() + (request.getPathInfo() == null ? "" : request.getPathInfo());
            if(!isIgnore(uri)) {
                LOGGER.info("==================== RequestInfoFilter Start ====================");
                LOGGER.info(request.getMethod() + " : " + uri);
                LOGGER.info("request time：{}" , request.getSession().getMaxInactiveInterval());

                logHeaders(request);
                logParams(request);

                filterChain.doFilter(request, response);

                long endTime = System.currentTimeMillis();
                LOGGER.info(request.getMethod() + " " + "taking：" + (endTime - startTime) + " ms");
                LOGGER.info("==================== RequestInfoFilter End ====================");
            } else {
                filterChain.doFilter(request, response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void logHeaders(HttpServletRequest request) {
        Map<String, String> headerMap = new HashMap<>();

        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headName = headers.nextElement();
            if (headName != null && !"".equals(headName)) {
                headerMap.put(headName, request.getHeader(headName));
            }
        }
        headerMap.put("RemoteHost", request.getRemoteHost() + ":" + request.getRemotePort());

        LOGGER.info(headerMap.toString());
    }

    private void logParams(HttpServletRequest request) {
        Map<String, String> maps = new HashMap<>();

        Enumeration<String> keys = request.getParameterNames();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            if (StringUtils.isNotEmpty(key)) {
                String values = request.getParameter(key);
                maps.put(key, values);
            }
        }

        LOGGER.info(maps.toString());
    }

    private static final boolean isIgnore(String url) {
        boolean ignore = false;
        int index = url.lastIndexOf(".");
        if(index > 0) {
            String subfix = url.substring(index + 1, url.length());
            if(ignoreList.contains(subfix)) {
                ignore = true;
            }
        }
        return ignore;
    }

    @Override
    public void destroy() {

    }

}
