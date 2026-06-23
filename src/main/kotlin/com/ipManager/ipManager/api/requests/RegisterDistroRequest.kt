package com.ipManager.ipManager.api.requests

import com.ipManager.ipManager.api.dto.RegisterDistroDto

data class RegisterDistroRequest(
    val quantity: Int? = 1,
    val beneficiaryId: String,
    val moreThanOne: Boolean,
    val justify: String? = null,
) {
    fun toDto() = RegisterDistroDto(
        quantity = this.quantity,
        beneficiaryId = this.beneficiaryId,
        moreThanOne = this.moreThanOne,
        justify = this.justify
    )
}
