package com.exe.study.jblog.controller;

import com.exe.study.jblog.domain.User;
import com.exe.study.jblog.dto.ResponseDTO;
import com.exe.study.jblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @Autowired
    private UserService userService;

    @GetMapping({"","/"})
    public String getPostList(){
        return "index";
    }

    @GetMapping("/auth/insertUser")
    public String insertUser(){
        return "user/insertUser";
    }


    @PostMapping("/auth/insertUser")
    public @ResponseBody ResponseDTO<?> insertUser(@RequestBody User user){ // ? 인이유는 어떤타입의 데이터가 반환될지 특정할수 없기 때문(문자,객체,컬렉션)

        User findUser = userService.getUser(user.getUsername());
        if(findUser.getUsername() == null){
            userService.insertUser(user);
            return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + "님의 회원가입이 성공적으로 완료되었습니다.");
        }else{
            return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), user.getUsername() + "님은 이미 존재하는 회원입니다.");
        }
    }


}
