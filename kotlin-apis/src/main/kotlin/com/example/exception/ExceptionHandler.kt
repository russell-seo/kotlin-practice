package com.example.exception

import lombok.extern.log4j.Log4j
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@Log4j
@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler
    fun globalException(e : Exception) : ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse(e.message!!, 1))
    }
}