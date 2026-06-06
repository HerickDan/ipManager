package com.ipManager.ipManager.api.requests

data class AddressRequest(
    val name: String,
    val complement: String? = null,
    val number: Int,
)
