package com.dev.api.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <pre>
 *
 * </pre>
 *
 * @author its11
 */
@Schema(description = "사용자 정보 응답")
@Getter
@AllArgsConstructor
public class UserResponse {

    @Schema(description = "사용자 아이디", example = "dev_user123")
    private String username;

    @Schema(description = "사용자 권한", example = "ROLE_USER")
    private String role;
}
