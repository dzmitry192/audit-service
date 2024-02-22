package com.innowise.sivachenko.web;

import com.innowise.sivachenko.model.error.ExceptionErrorDto;
import com.innowise.sivachenko.model.exception.ActionNotFoundException;
import org.apache.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {
    /**
     * 400
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionErrorDto> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest().body(new ExceptionErrorDto(exception.getMessage()));
    }

    /**
     * 404
     */
    @ExceptionHandler(ActionNotFoundException.class)
    public ResponseEntity<ExceptionErrorDto> actionNotFoundExceptionHandler(ActionNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(new ExceptionErrorDto(exception.getMessage()));
    }

    /**
     * 500
     */
    @ExceptionHandler
    public ResponseEntity<ExceptionErrorDto> handler(Throwable e) {
        return ResponseEntity.status(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR).body(new ExceptionErrorDto(e.getMessage()));
    }
}
