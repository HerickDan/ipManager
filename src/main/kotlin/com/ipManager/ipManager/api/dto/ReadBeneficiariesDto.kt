package com.ipManager.ipManager.api.dto

data class ReadBeneficiariesDto(
    val id: String,
    val firstName: String,
    val lastName: String,
    val familyMemberNumber: Int,
    val address: AddressDto,
    val number: CellPhoneDto
)