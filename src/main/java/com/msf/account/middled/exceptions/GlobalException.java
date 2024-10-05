package com.msf.account.middled.exceptions;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalException {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<?> feignException(FeignException ex) {
        return ResponseEntity
                .status(ex.status())
                .contentType(MediaType.APPLICATION_JSON)
                .body(ex.contentUTF8());
    }
}
