package com.innowise.sivachenko.model.error;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ExceptionErrorDto {
    private String logref;
    private String message;

    public ExceptionErrorDto(String message) {
        this.logref = "error";
        this.message = message;
    }
}
