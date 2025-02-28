package com.cos.security1.repository;

import com.cos.security1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// CRUD 함수를 JpaRefpository가 들고 있음
// @Repository 어노테이션 없어도 IoC됨. 이윤 : JpaRepository 상속했기 때문
public interface UserRepository extends JpaRepository<User, Integer> {
}
