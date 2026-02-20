package com.ipManager.ipManager.config.GlobalException

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice

@ControllerAdvice

class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException::class)
    fun notFoundException(notFoundException: NotFoundException): ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundException.message)
    }
}