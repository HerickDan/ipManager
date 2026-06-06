package com.ipManager.ipManager.api.requests

data class CellPhoneRequest(
    val countryCode: Int,
    val ddd: Int,
    val prefixLine: Int
)
