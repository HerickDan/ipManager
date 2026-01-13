package com.ipManager.ipManager.commons.requests

import com.ipManager.ipManager.commons.dto.MemberDto

data class CreateMemberRequest(
    val firstName: String,
    val lastName: String,
    val password: String,
    val email: String,

    ) {
    fun toDto(): MemberDto =
        MemberDto(
            firstName = this.email,
            lastName = this.lastName,
            password = this.password,
            email = this.email
        )
}
