package dev.briiiqtt.shorturl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> handle(InvalidInputException e) {
        ErrorResponse error = ErrorResponse.of(CustomError.INVALID_INPUT);
        return ResponseEntity.status(error.getStatus()).body(error);
    }

    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(UrlNotFoundException e) {
        ErrorResponse error = ErrorResponse.of(CustomError.URL_NOT_FOUND);
        return ResponseEntity.status(error.getStatus()).body(error);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handle(NoResourceFoundException e) {
        ErrorResponse error = ErrorResponse.of(CustomError.NOT_FOUND);
        return ResponseEntity.status(error.getStatus()).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handle(Exception e) {
        ErrorResponse error = ErrorResponse.of(CustomError.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(error.getStatus()).body(error);
    }
}
