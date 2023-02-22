package com.exe.study.jblog.service;


import com.exe.study.jblog.domain.RoleType;
import com.exe.study.jblog.domain.User;
import com.exe.study.jblog.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

   // @Autowired
    // private PasswordEncoder passwordEncoder;

    @Transactional
    public void insertUser(User user) {
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }


    @Transactional(readOnly = true)
    public User getUser(String username) {

        // 검색 결과가 없다면 빈 객체를 리턴한다.(일반 코드)
        User findUser = userRepository.findByUsername(username).orElseGet(()->{
            return new User();
        });
        return findUser;
    }

/*
    // 비밀번호를 암호화하여 설정한다.
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRole(RoleType.USER);
        if(user.getOauth() == null) {
        user.setOauth(OAuthType.JBLOG);
    }
        userRepository.save(user);
*/


/*
    @Transactional
    public User updateUser(User user) {
        User findUser = userRepository.findById(user.getId()).get();
        findUser.setUsername(user.getUsername());
        findUser.setPassword(passwordEncoder.encode(user.getPassword()));
        findUser.setEmail(user.getEmail());

        return findUser;
    }




*/



}