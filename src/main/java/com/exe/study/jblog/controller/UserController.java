package com.exe.study.jblog.controller;

import com.exe.study.jblog.domain.RoleType;
import com.exe.study.jblog.domain.User;
import com.exe.study.jblog.exception.JBlogException;
import com.exe.study.jblog.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public @ResponseBody String insertUser(@RequestBody User user) {
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return user.getUsername() + " 회원님의 가입이 성공적으로 완료 되었습니다.";
    }

    @GetMapping("/user/get/{id}")
    public @ResponseBody User getUser(@PathVariable int id) {
        User findUser = userRepository.findById(id).orElseThrow(() -> {
            return new JBlogException(id + " 번 회원이 존재하지 않습니다.");
        });
        return findUser;
    }

    @Transactional //원래는 서비스에서 사용해야함
    @PutMapping("/user")
    public @ResponseBody String updateUser(@RequestBody User user){
        User findUser = userRepository.findById(user.getId()).orElseThrow(()->{
            return new JBlogException(user.getId() + " 번 회원이 존재하지 않습니다.");
        });
        findUser.setUsername(user.getUsername());
        findUser.setPassword(user.getPassword());
        findUser.setEmail(user.getEmail());
        // userRepository.save(findUser); @Transactional이용시에 jpa에서 변경감지 기능을 통해 자동으로 update진행
        return "회원 수정 성공";
    }

    @DeleteMapping("/user/{id}")
    public @ResponseBody String deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
        return "회원삭제 성공!!";
    }
}
