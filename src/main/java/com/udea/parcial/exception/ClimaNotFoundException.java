package com.udea.parcial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClimaNotFoundException extends RuntimeException {
    public ClimaNotFoundException(String message) {
        super(message);
    }
}