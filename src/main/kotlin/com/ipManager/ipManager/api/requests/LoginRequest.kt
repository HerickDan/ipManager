package com.ipManager.ipManager.api.requests

import com.ipManager.ipManager.api.dto.LoginDto

data class LoginRequest(
    val email: String,
    val password: String,
) {
    fun toDto() = LoginDto(
        email = this.email,
        password = this.password
    )
}
