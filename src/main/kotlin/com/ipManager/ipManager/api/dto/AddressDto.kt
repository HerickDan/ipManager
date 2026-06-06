package com.ipManager.ipManager.api.dto

data class AddressDto(
    val name: String,
    val complement: String? = null,
    val number: Int,
)