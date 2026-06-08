package com.ipManager.ipManager.services

import com.ipManager.ipManager.api.dto.CreateBeneficiariesDto
import com.ipManager.ipManager.api.dto.UpdateUserInfoDto
import com.ipManager.ipManager.commons.errorMessages.ErrorMessages
import com.ipManager.ipManager.config.Exceptions.NotFoundException
import com.ipManager.ipManager.repositories.entities.AddressEntity
import com.ipManager.ipManager.repositories.interfaces.AddressRepository
import com.ipManager.ipManager.repositories.interfaces.BeneficiariesRepository
import org.springframework.stereotype.Service

@Service
class BeneficiariesService(
    val beneficiariesRepository: BeneficiariesRepository,
    val addressRepository: AddressRepository
) {
    fun createBeneficiary(req: CreateBeneficiariesDto) {
        val beneficiary = beneficiariesRepository.save(req.toMemberEntityEntity())
        val addressParameters = req.address

        addressRepository.save(
            AddressEntity(
                name = addressParameters.name,
                complement = addressParameters.complement,
                number = addressParameters.number,
                resident = beneficiary
            )
        )
    }

    fun disableBeneficiary(id: String) {
        val beneficiary = beneficiariesRepository.findByApiId(id)
            ?: throw NotFoundException(ErrorMessages.NOT_FOUND_EXCEPTION)
        beneficiary.active = false
        beneficiariesRepository.save(beneficiary)
    }

    fun updateUserInfo(id: String, req: UpdateUserInfoDto) {
        val beneficiary = beneficiariesRepository.findByApiId(id)
            ?: throw NotFoundException(ErrorMessages.NOT_FOUND_EXCEPTION)

        val address = addressRepository.findByResident(beneficiary)
        val updatedAddress = address.copy(
            name = req.addressName ?: address.name,
            complement = req.complement ?: address.complement,
            number = req.number ?: address.number
        )
        addressRepository.save(updatedAddress)
    }
}