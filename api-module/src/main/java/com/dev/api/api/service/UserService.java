package com.dev.api.api.service;

import com.dev.api.api.dto.LoginRequest;
import com.dev.api.api.dto.SignUpRequest;
import com.dev.api.api.dto.UserResponse;
import com.dev.api.api.dto.UserUpdateRequest;
import com.dev.api.core.mapper.UserMapper;
import com.dev.api.core.model.User;
import com.dev.api.core.utils.JwtTokenProvider;
import com.dev.api.core.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 *
 * </pre>
 *
 * @author its11
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    /**
     * 회원 가입
     *
     * @param request
     */
    @Transactional
    public void signUp(SignUpRequest request) {
        // 1. 중복 체크
        if (userMapper.existsByUsername(request.getUsername()) > 0) {
            throw new RuntimeException(MessageUtils.getMessage("auth.signup.fail.duplicate"));
        }

        // 2. 객체 생성 및 비밀번호 암호화
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // 암호화 핵심!

        // 3. 저장
        userMapper.insertUser(user);
    }

    /**
     * 로그인
     *
     * @param request
     * @return
     */
    public String login(LoginRequest request) {
        // 1. 유저 확인
        User user = userMapper.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException(MessageUtils.getMessage("auth.login.fail.notfounduser")));

        // 2. 비밀번호 일치 확인 (암호화된 비번과 비교)
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException(MessageUtils.getMessage("auth.login.fail.password"));
        }

        // 3. 인증 성공 시 JWT 토큰 발행 및 반환
        return jwtTokenProvider.createToken(user.getUsername(), user.getRole());
    }

    /**
     * 회원 비밀번호 수정
     *
     * @param username
     * @param dto
     */
    @Transactional
    public void updateInfo(String username, UserUpdateRequest dto) {
        User user = new User();
        user.setUsername(username);
        // 새 비밀번호가 있다면 암호화하여 세팅
        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));

        userMapper.updateUser(user);
    }

    /**
     * 회원 탈퇴
     *
     * @param username
     */
    @Transactional
    public void withdraw(String username) {
        userMapper.deleteByUsername(username);
    }

    /**
     * 사용자 정보 조회
     *
     * @param username
     * @return
     */
    public UserResponse getInfo(String username) {
        User user = userMapper.findByUsername(username)
                .orElseThrow(() -> new RuntimeException(MessageUtils.getMessage("auth.signup.fail.notfounduser")));

        // UserResponseDto -> UserResponse로 변경
        return new UserResponse(user.getUsername(), user.getRole());
    }
}