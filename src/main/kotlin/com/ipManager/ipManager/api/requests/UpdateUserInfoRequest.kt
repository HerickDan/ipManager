package com.ipManager.ipManager.api.requests

import com.ipManager.ipManager.api.dto.UpdateUserInfoDto
import kotlin.String

data class UpdateUserInfoRequest(
    val addressName: String? = null,
    val complement: String? = null,
    val number: Int? = null,
    val countryCode: Int? = null,
    val ddd: Int? = null,
    val prefixLine: Int? = null
) {
    fun toDto() = UpdateUserInfoDto(
        addressName = this.addressName,
        complement = this.complement,
        number = this.number,
        countryCode = this.countryCode,
        ddd = this.ddd,
        prefixLine = this.prefixLine
    )
}
