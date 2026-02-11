package com.dev.api.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 *
 * </pre>
 *
 * @author its11
 */
@Schema(description = "로그인 요청 정보")
@Getter @Setter
public class LoginRequest {

    @Schema(description = "사용자 아이디", example = "dev_user123")
    private String username;

    @Schema(description = "비밀번호", example = "password1234!")
    private String password;
}

