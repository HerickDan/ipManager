package com.ipManager.ipManager.api.dto

data class UpdateUserInfoDto(
    val addressName: String? = null,
    val complement: String? = null,
    val number: Int? = null,
    val countryCode: Int? = null,
    val ddd: Int? = null,
    val prefixLine: Int? = null
)