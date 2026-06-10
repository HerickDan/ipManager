package com.ipManager.ipManager.repositories.interfaces

import com.ipManager.ipManager.repositories.entities.BeneficiariesEntity
import com.ipManager.ipManager.repositories.entities.CellPhoneEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CellPhoneRepository: JpaRepository<CellPhoneEntity, Long> {
    fun findByPhoneOwner(resident: BeneficiariesEntity): CellPhoneEntity
}