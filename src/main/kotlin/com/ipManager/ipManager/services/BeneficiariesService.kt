package com.ipManager.ipManager.services

import com.ipManager.ipManager.api.dto.CreateBeneficiariesDto
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

        addressRepository.save(AddressEntity(
            name = addressParameters.name,
            complement = addressParameters.complement,
            number = addressParameters.number,
            resident = beneficiary
        ))
    }

}