package com.ipManager.ipManager.api.responses

import org.springframework.http.HttpStatus

data class ErrorResponse(
    val statusCode: HttpStatus,
    val errorMessage: String
)
