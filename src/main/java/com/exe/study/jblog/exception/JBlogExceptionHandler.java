package com.exe.study.jblog.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

// 예외처리 핸들러 적용 : 모든 종류의 예외를 처리하기위해서 작성, 예외들의 일괄처리
@ControllerAdvice
@RestController
public class JBlogExceptionHandler {

    // 발생된 모든 예외를 받아서 HTML메세지로 반환
    @ExceptionHandler(value = Exception.class)
    public String globalExceptionHandler(Exception e){ //
        return "<h1>" + e.getMessage() + "</h1>";
    }
}
