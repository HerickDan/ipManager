package com.ipManager.ipManager.repositories.interfaces

import com.ipManager.ipManager.repositories.entities.BasketDistroEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BasketDistroRepository: JpaRepository<BasketDistroEntity,Long> {
    @Query("""
    SELECT b FROM BasketDistroEntity b
    WHERE b.adminName = :adminName
    AND YEAR(b.distributedIn) = :year
    AND MONTH(b.distributedIn) = :month
    """)
    fun findByAdminNameAndMonthAndYear(
        adminName: String,
        month: Int,
        year: Int
    ): List<BasketDistroEntity>
}
