package com.omlucy.shortlink.exception;

import com.omlucy.shortlink.dto.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.validation.BindValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lucy_
 * @date 2025/2/28
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    public ApiResponse<String> handleBusinessException(BizException ex) {
        log.error("业务异常：{}", ex.getMessage());
        ErrorCode errorCode = ex.getErrorCode();
        return ApiResponse.fail(HttpStatus.BAD_REQUEST.value(), errorCode.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("参数校验失败：{}", ex.getMessage());
        String errorMessage = ex.getBindingResult().getAllErrors().getFirst().getDefaultMessage();
        return ApiResponse.fail(HttpStatus.BAD_REQUEST.value(), errorMessage);
    }

    @ExceptionHandler(BindValidationException.class)
    public ApiResponse<String> handleBindValidationException(BindValidationException ex) {
        log.error("参数校验失败：{}", ex.getMessage());
        String errorMessage = ex.getValidationErrors().getAllErrors().getFirst().getDefaultMessage();
        return ApiResponse.fail(HttpStatus.BAD_REQUEST.value(), errorMessage);
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<String> handleException(Exception ex) {
        log.error("系统异常：{}", ex.getMessage());
        return ApiResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), "System Error");
    }
}
