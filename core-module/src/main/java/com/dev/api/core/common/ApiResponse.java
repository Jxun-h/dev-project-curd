package com.dev.api.core.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <pre>
 *
 * </pre>
 *
 * @author its11
 */
@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    private String status;  // "success" 또는 "fail"
    private String message; // 사용자에게 보여줄 메시지 (에러 메시지 포함)
    private T data;         // 실제 결과 데이터 (없으면 null)

    // 성공 응답용 정적 팩토리 메서드
    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>("success", message, data);
    }

    public static <T> ApiResponse<T> success(String message) {
        return new ApiResponse<>("success", message, null);
    }

    // 실패 응답용 정적 팩토리 메서드
    public static <T> ApiResponse<T> fail(String message) {
        return new ApiResponse<>("fail", message, null);
    }
}