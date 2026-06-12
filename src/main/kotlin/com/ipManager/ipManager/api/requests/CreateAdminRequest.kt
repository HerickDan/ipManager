package com.ipManager.ipManager.api.requests

import com.ipManager.ipManager.api.dto.AdminDto
import jakarta.validation.Valid
import org.jetbrains.annotations.NotNull

data class CreateAdminRequest(
    @NotNull
    val firstName: String,
    @NotNull
    val lastName: String,
    @NotNull
    val password: String,
    @NotNull
    val email: String,
    val description: String ? = "Default description"
    ) {
    fun toDto(): AdminDto =
        AdminDto(
            firstName = this.firstName,
            lastName = this.lastName,
            password = this.password,
            email = this.email
        )
}
