package com.ipManager.ipManager.commons.requests

data class CreateMemberRequest(
    val firstName: String,
    val lastName: String,
    val password: String,

){

    companion object{
        fun toDto
    }
}
