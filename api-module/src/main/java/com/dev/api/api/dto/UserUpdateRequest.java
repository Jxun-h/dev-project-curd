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
@Schema(description = "회원 정보 수정 요청 정보")
@Getter @Setter
public class UserUpdateRequest {

    @Schema(description = "변경할 새 비밀번호", example = "new_password5678!")
    private String newPassword;
}
