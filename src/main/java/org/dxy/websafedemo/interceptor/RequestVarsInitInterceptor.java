package org.dxy.websafedemo.interceptor;

import org.dxy.websafedemo.support.EnvConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestVarsInitInterceptor implements HandlerInterceptor {

    @Autowired
    private EnvConfiguration envConfiguration;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        request.setAttribute("site", envConfiguration.site());
        request.setAttribute("hackSite", envConfiguration.hackSite());
    }
}
