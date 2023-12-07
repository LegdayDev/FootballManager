package com.legdayDev.FootballManager.handler;

import com.legdayDev.FootballManager.dto.CMRespDto;
import com.legdayDev.FootballManager.handler.ex.CustomApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> apiException(Exception e){
        log.error(e.getMessage());
        return new ResponseEntity<>(new CMRespDto<>(-1,e.getMessage(),null), HttpStatus.BAD_REQUEST);
    }

}
