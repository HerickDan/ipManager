package com.ipManager.ipManager.api.dto

import com.ipManager.ipManager.repositories.entities.BasketDistroEntity

data class ReadDistributionDto(
    val apiId: String?,
    val quantity: Int,
    val distributedIn: String?,
    val adminName: String,
    val beneficiaryName: String,
    val moreThanOne: Boolean?,
    val justify: String?,
) {
    companion object {
        fun fromEntity(entity: BasketDistroEntity) = ReadDistributionDto(
            apiId = entity.apiId,
            quantity = entity.quantity,
            distributedIn = entity.distributedIn?.toString(),
            adminName = entity.adminName,
            beneficiaryName = "${entity.beneficiary.firstName} ${entity.beneficiary.lastName}",
            moreThanOne = entity.moreThanOne,
            justify = entity.justify,
        )
    }
}
