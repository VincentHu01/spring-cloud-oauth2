package com.ai.account.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class AdviceController {

    @ExceptionHandler(value = Exception.class)
    public String ExceptionHandler(Exception ex) {
        log.error(">>>>>>>>>>>>Advice Controller Exception");
        String message = ex.getMessage();
        return "Advice Controller Exception: " + message;
    }
}
