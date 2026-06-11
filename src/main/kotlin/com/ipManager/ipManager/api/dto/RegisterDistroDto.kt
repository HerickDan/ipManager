package com.ipManager.ipManager.api.dto

data class RegisterDistroDto(
    val quantity: Int ? = 1,
    val beneficiaryId: String,
    val moreThanOne: Boolean,
    val justify: String ? = null,
)
