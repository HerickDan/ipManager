package com.ipManager.ipManager.api.responses

import com.ipManager.ipManager.api.dto.ReadBeneficiariesDto

data class ReadBeneficiariesResponse(
    val id: String,
    val firstName: String,
    val lastName: String,
    val familyMemberNumber: Int,
    val address: AddressResponse,
    val number: CellPhoneResponse
) {
    companion object {
        fun fromDto(dto: ReadBeneficiariesDto) = ReadBeneficiariesResponse(
            id = dto.id,
            firstName = dto.firstName,
            lastName = dto.lastName,
            familyMemberNumber = dto.familyMemberNumber,
            address = AddressResponse(
                name = dto.address.name,
                complement = dto.address.complement,
                number = dto.address.number
            ),
            number = CellPhoneResponse(
                countryCode = dto.number.countryCode,
                ddd = dto.number.ddd,
                prefixLine = dto.number.prefixLine
            )
        )
    }
}
