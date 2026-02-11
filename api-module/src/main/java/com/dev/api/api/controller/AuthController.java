package com.dev.api.api.controller;

import com.dev.api.api.dto.LoginRequest;
import com.dev.api.api.dto.SignUpRequest;
import com.dev.api.api.service.UserService;
import com.dev.api.core.common.ApiResponse;
import com.dev.api.core.utils.MessageUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author its11
 */
@Tag(name = "1. 인증 (Auth)", description = "회원가입 및 로그인을 담당하는 API입니다.")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @Operation(summary = "회원가입", description = "아이디와 비밀번호를 입력받아 새로운 사용자를 등록합니다.")
    @PostMapping("/signup")
    public ApiResponse<Void> signUp(@Valid @RequestBody SignUpRequest request) {
        userService.signUp(request);

        // 리턴 타입을 ApiResponse로 감싸서 반환.
        return ApiResponse.success(MessageUtils.getMessage("auth.signup.success"));
    }

    @Operation(summary = "로그인", description = "아이디와 비밀번호로 인증을 진행하고, 성공 시 JWT 토큰을 발급합니다.")
    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody LoginRequest request) {
        String token = userService.login(request);
        // 응답 객체의 data 필드에 생성된 토큰을 담아 보냅니다.
        return ApiResponse.success(token, MessageUtils.getMessage("auth.login.success"));
    }
}
