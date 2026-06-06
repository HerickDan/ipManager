package com.ipManager.ipManager.repositories.interfaces

import com.ipManager.ipManager.repositories.entities.BeneficiarieEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BeneficiariesRepository: JpaRepository<Long, BeneficiarieEntity> {
}