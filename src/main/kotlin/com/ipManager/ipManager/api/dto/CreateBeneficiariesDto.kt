package com.ipManager.ipManager.api.dto

import com.ipManager.ipManager.repositories.entities.BeneficiariesEntity

data class CreateBeneficiariesDto(
    val firstName: String,
    val lastName: String,
    val familyMemberNumber: Int,
    val address: AddressDto
) {
    fun toMemberEntityEntity() = BeneficiariesEntity(
        firstName = this.firstName,
        lastName = this.lastName,
        familyMembersNumber = this.familyMemberNumber,
    )
}