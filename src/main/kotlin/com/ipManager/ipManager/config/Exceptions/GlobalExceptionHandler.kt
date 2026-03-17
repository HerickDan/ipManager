package com.ipManager.ipManager.config.Exceptions

import com.ipManager.ipManager.api.dto.ErrorDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice

@ControllerAdvice

class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException::class)
    fun notFoundException(notFoundException: NotFoundException): ResponseEntity<ErrorDto>{
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ErrorDto(
                statusCode = HttpStatus.NOT_FOUND,
                errorMessage = notFoundException.message!!
            )
        )
    }

    @ExceptionHandler(BadRequestException::class)
    fun businessException(badRequest: BadRequestException): ResponseEntity<ErrorDto>{
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ErrorDto(
                statusCode = HttpStatus.BAD_REQUEST,
                errorMessage = badRequest.message!!
            )
        )
    }

    @ExceptionHandler(ConflictException::class)
    fun businessException(badRequest: ConflictException): ResponseEntity<ErrorDto>{
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
            ErrorDto(
                statusCode = HttpStatus.CONFLICT,
                errorMessage = badRequest.message!!
            )
        )
    }
}