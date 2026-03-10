package com.ipManager.ipManager.api.dto

import org.springframework.http.HttpStatus

data class ErrorDto (
    val statusCode: HttpStatus,
    val errorMessage: String
)