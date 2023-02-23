package com.exe.study.jblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 인터셉터 환경설정 적용하기
@Configuration
public class JBlogWebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(
                new AuthenticateInterceptor()).
                addPathPatterns("/","/post/**"); //세션에 정보가 존재한 사람만 접근가능(인증)

    }
}
