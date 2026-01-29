package dev.briiiqtt.shorturl.exception;

import lombok.Getter;

@Getter
public enum CustomError {
    // Global
    INVALID_INPUT(400, "INVALID_INPUT", "입력값이 올바르지 않습니다."),
    NOT_FOUND(404, "NOT_FOUND", "요청하신 것을 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR", "서버 내부 에러"),

    // URL
    URL_NOT_FOUND(404, "URL_NOT_FOUND", "해당 URL을 찾을 수 없습니다.");

    private final int status;
    private final String code;
    private final String message;

    CustomError(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}