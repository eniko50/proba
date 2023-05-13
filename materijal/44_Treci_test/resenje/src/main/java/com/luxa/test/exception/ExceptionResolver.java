package com.luxa.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionResolver {
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity forbiddenException(HttpServletRequest request, ForbiddenException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity notFoundException(HttpServletRequest request, NotFoundException exception) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
