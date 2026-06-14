package com.ipManager.ipManager.repositories.interfaces

import com.ipManager.ipManager.repositories.entities.BasketDistroEntity
import com.ipManager.ipManager.repositories.entities.BeneficiariesEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BasketDistroRepository: JpaRepository<BasketDistroEntity,Long> {
    @Query("""
    SELECT b FROM BasketDistroEntity b
    WHERE b.beneficiary = :beneficiary
    AND YEAR(b.distributedIn) = :year
    AND MONTH(b.distributedIn) = :month
    """)
    fun findByBeneficiaryAndMonthAndYear(
        beneficiary: BeneficiariesEntity,
        month: Int,
        year: Int
    ): List<BasketDistroEntity>

    @Query("""
    SELECT b FROM BasketDistroEntity b
    WHERE YEAR(b.distributedIn) = :year
    AND MONTH(b.distributedIn) = :month
    """)
    fun findByMonthAndYear(
        month: Int,
        year: Int
    ): List<BasketDistroEntity>
}
