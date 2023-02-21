package com.exe.study.jblog;

import com.exe.study.jblog.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface UserMapper {

    // 등록
    @Insert("INSERT INTO USERS(ID, USERNAME, PASSWORD, EMAIL) " +
            "VALUES((SELECT NVL(MAX(ID), 0) + 1 FROM USER), #{username}, #{password}, #{email})")
    public void insertUser(User user);

    // 수정
    @Update("UPDATE USERS PASSWORD=#{password}, EMAIL=#{eamil} WHERE ID = #{id}")
    public void updateUser(User user);

    // 삭제
    @Delete("DELETE USERS WHERE ID = #{id}")
    public void deleteUser(User user);

    // 단건조회
    @Select("SELECT * FROM USERS WHERE USERNAME = #{username}")
    public void getUser(User user);

    // 전체조회
    @Select("SELECT * FROM USERS ORDER BY USERNAME DESC")
    public List<User> getUserList();
}
