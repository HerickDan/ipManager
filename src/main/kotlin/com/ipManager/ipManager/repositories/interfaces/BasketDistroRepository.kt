package com.ipManager.ipManager.repositories.interfaces

import com.ipManager.ipManager.repositories.entities.BasketDistroEntity
import com.ipManager.ipManager.repositories.entities.BasketEntity
import com.ipManager.ipManager.repositories.entities.MemberEntity
import org.apache.catalina.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BasketDistroRepository: JpaRepository<BasketDistroEntity,Long> {
    @Query("""
    SELECT b FROM BasketDistroEntity b
    WHERE b.member = :member
    AND YEAR(b.distributedIn) = :year
    AND MONTH(b.distributedIn) = :month
""")
    fun findByMemberAndMonthAndYear(
        member: MemberEntity,
        month: Int,
        year: Int
    ): List<BasketDistroEntity>
}