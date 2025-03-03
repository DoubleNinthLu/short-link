package com.omlucy.shortlink.exception;

import lombok.Getter;

/**
 * 业务异常
 *
 * @author lucy_
 * @date 2025/2/28
 **/
@Getter
public enum ErrorCode {
    //
    USER_NOT_FOUND(1001, "User not found"),
    INSUFFICIENT_BALANCE(1002, "Insufficient balance"),
    ;


    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // 根据状态码查找枚举
    public static ErrorCode fromCode(int code) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.getCode() == code) {
                return errorCode;
            }
        }
        throw new IllegalArgumentException("Unknown error code: " + code);
    }
}