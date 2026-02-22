package com.ipManager.ipManager.api.dto

data class CreateMemberDto(
    val firstName: String,
    val lastName: String,
    val password: String,
    val email: String,
)
