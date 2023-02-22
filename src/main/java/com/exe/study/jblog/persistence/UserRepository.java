package com.exe.study.jblog.persistence;

import com.exe.study.jblog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
