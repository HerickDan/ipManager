package com.ipManager.ipManager.api.responses

import com.ipManager.ipManager.api.dto.ReadDistributionDto

data class ReadDistributionResponse(
    val apiId: String?,
    val quantity: Int,
    val distributedIn: String?,
    val adminName: String,
    val beneficiaryName: String,
    val moreThanOne: Boolean?,
    val justify: String?,
) {
    companion object {
        fun fromDto(dto: ReadDistributionDto) = ReadDistributionResponse(
            apiId = dto.apiId,
            quantity = dto.quantity,
            distributedIn = dto.distributedIn,
            adminName = dto.adminName,
            beneficiaryName = dto.beneficiaryName,
            moreThanOne = dto.moreThanOne,
            justify = dto.justify
        )
    }
}
