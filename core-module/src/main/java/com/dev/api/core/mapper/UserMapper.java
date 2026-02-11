package com.dev.api.core.mapper;

import com.dev.api.core.model.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.Optional;

@Mapper
public interface UserMapper {

    // 회원 가입
    void insertUser(User user);

    // 중복 검사
    int existsByUsername(String username); // 중복 체크용

    // 로그인
    Optional<User> findByUsername(String username);

    // 정보 수정 (닉네임이나 특정 필드 변경)
    void updateUser(User user);

    // 회원 탈퇴
    void deleteByUsername(String username);
}