package dev.briiiqtt.shorturl.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {
    private final int status;
    private final String code;
    private final String message;
    private final LocalDateTime timestamp;

    public static ErrorResponse of(CustomError error) {
        return ErrorResponse.builder()
                .status(error.getStatus())
                .code(error.getCode())
                .message(error.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
