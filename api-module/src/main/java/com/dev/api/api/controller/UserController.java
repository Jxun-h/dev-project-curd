package com.dev.api.api.controller;

import com.dev.api.api.dto.UserResponse;
import com.dev.api.api.dto.UserUpdateRequest;
import com.dev.api.api.service.UserService;
import com.dev.api.core.common.ApiResponse;
import com.dev.api.core.utils.MessageUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author its11
 */
@Tag(name = "2. 사용자 (User)", description = "로그인한 사용자의 정보 조회, 수정, 탈퇴를 담당하는 API입니다.")
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 1. 정보 조회 (GET) - 페이지 로딩 시 사용
    @Operation(summary = "내 정보 조회", description = "현재 로그인한 사용자의 아이디와 권한 정보를 가져옵니다.")
    @GetMapping("/me")
    public ApiResponse<UserResponse> getMyInfo(@AuthenticationPrincipal UserDetails userDetails) {
        // 유저 정보를 조회해서 반환하는 로직 (Service 구현 필요)
        return ApiResponse.success(userService.getInfo(userDetails.getUsername()), MessageUtils.getMessage("user.me.success"));
    }

    // 2. 정보 수정 (POST)
    @Operation(summary = "회원 정보 수정", description = "사용자의 비밀번호 등 개인 정보를 수정합니다.")
    @PostMapping("/update")
    public ApiResponse<Void> update(@AuthenticationPrincipal UserDetails userDetails,
                                    @RequestBody UserUpdateRequest dto) {
        userService.updateInfo(userDetails.getUsername(), dto);
        return ApiResponse.success(MessageUtils.getMessage("user.update.success"));
    }

    // 3. 회원 탈퇴 (POST)
    @Operation(summary = "회원 탈퇴", description = "현재 로그인한 계정을 삭제하고 DB에서 제거합니다.")
    @PostMapping("/withdraw")
    public ApiResponse<Void> withdraw(@AuthenticationPrincipal UserDetails userDetails) {
        userService.withdraw(userDetails.getUsername());
        return ApiResponse.success(MessageUtils.getMessage("user.withdraw.success"));
    }
}
