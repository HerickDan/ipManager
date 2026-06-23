package com.ipManager.ipManager.api.responses

data class AddressResponse(
    val name: String,
    val complement: String? = null,
    val number: Int,
)
