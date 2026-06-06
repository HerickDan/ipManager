package com.ipManager.ipManager.api.dto

data class CreateBeneficiariesDto(
    val name: String,
    val familyMemberNumber: Int,
    val number: CellPhoneDto,
    val address: AddressDto
)