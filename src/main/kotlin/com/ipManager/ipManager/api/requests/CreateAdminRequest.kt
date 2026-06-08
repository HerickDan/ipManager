package com.ipManager.ipManager.api.requests

import com.ipManager.ipManager.api.dto.AdminDto

data class CreateAdminRequest(
    val firstName: String,
    val lastName: String,
    val password: String,
    val email: String,
    val description: String ? = "Default description"
    ) {
    fun toDto(): AdminDto =
        AdminDto(
            firstName = this.email,
            lastName = this.lastName,
            password = this.password,
            email = this.email
        )
}
