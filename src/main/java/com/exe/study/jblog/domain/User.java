package com.exe.study.jblog.domain;

import lombok.*;

@Setter
@Getter
@Builder // 빌더패턴 적용
@NoArgsConstructor  // 기본생성자 생성
@AllArgsConstructor // 전체생성자 생성
@ToString
public class User {

    private int id; //회원 일련번호
    private String username; // 아이디
    private String password; // 비밀번호
    private String email;    // 이메일
}
