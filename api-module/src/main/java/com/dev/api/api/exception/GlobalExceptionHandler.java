package com.dev.api.api.exception;

import com.dev.api.core.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <pre>
 *
 * </pre>
 *
 * @author its11
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. 비즈니스 로직 중 발생하는 커스텀 에러 처리
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<Void>> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.ok(ApiResponse.fail(e.getMessage()));
    }

    // 2. @Valid 유효성 검사 실패 시 처리 (여자친구가 빈 값을 보냈을 때)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return ResponseEntity.ok(ApiResponse.fail(message));
    }

    // 3. 그 외 예상치 못한 모든 에러 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleAllException(Exception e) {
        return ResponseEntity.internalServerError().body(ApiResponse.fail("서버 내부 오류가 발생했습니다."));
    }
}
