package com.ipManager.ipManager.api.requests

import com.ipManager.ipManager.api.dto.AddressDto
import com.ipManager.ipManager.api.dto.CellPhoneDto
import com.ipManager.ipManager.api.dto.CreateBeneficiariesDto

data class CreateBeneficiariesRequest(
    val firstName: String,
    val lastName: String,
    val familyMemberNumber: Int,
    val number: CellPhoneRequest,
    val address: AddressRequest
){
    fun toDto(): CreateBeneficiariesDto{
       return CreateBeneficiariesDto(
            firstName = this.firstName,
            lastName = this.lastName,
            familyMemberNumber = this.familyMemberNumber,
            number = CellPhoneDto(
                countryCode = this.number.countryCode,
                ddd = this.number.ddd,
                prefixLine = this.number.prefixLine
            ),
            address = AddressDto(
                name = this.address.name,
                complement = this.address.complement,
                number = this.address.number
            )
        )
    }
}

