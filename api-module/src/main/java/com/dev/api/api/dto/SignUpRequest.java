package com.dev.api.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author its11
 */
@Schema(description = "회원가입 요청 정보")
@Getter @Setter
public class SignUpRequest {

    @Schema(description = "사용자 아이디", example = "dev_user123")
    @NotBlank(message = "아이디는 필수입니다.")
    private String username;

    @Schema(description = "비밀번호 (8자 이상 권장)", example = "password1234!")
    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;
}
