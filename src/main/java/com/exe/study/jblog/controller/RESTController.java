package com.exe.study.jblog.controller;


import org.springframework.web.bind.annotation.*;

@RestController // 메소드의 반환값을 자동으로 JSON타입으로 변환
public class RESTController {

    // GET : SELECT(조회)
    @GetMapping("/jblog")
    public String httpGet(){
        return "GET 요청 처리";
    }

    // POST : INSERT(등록)
    @PostMapping("/jblog")
    public String httpPost(){
        return "POST 요청 처리";
    }

    // PUT : UPDATE(수정)
    @PutMapping("/jblog")
    public String httpPut(){
        return "PUT 요청 처리";
    }

    // DELETE : DELETE(삭제)
    @DeleteMapping("/jblog")
    public String httpDelete(){
        return "DELETE 요청 처리";
    }






}
