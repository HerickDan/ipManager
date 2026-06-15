package com.ipManager.ipManager.repositories.interfaces

import com.ipManager.ipManager.repositories.entities.BeneficiariesEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BeneficiariesRepository: JpaRepository<BeneficiariesEntity, Long> {
    fun findByApiId(apiId: String): BeneficiariesEntity?
    fun findAllByActive(active: Boolean): List<BeneficiariesEntity>
}