package org.dxy.websafedemo;


import org.dxy.websafedemo.interceptor.LoginInterceptor;
import org.dxy.websafedemo.interceptor.RequestVarsInitInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    public RequestVarsInitInterceptor requestVarsInitInterceptor() {
        return new RequestVarsInitInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(requestVarsInitInterceptor()).addPathPatterns("/**");
    }

}

