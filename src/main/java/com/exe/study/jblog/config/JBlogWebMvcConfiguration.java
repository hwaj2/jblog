package com.exe.study.jblog.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 인터셉터 환경설정 적용하기
public class JBlogWebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(
                new AuthenticateInterceptor()).addPathPatterns("/"); //인덱스페이지

    }
}
