package com.ipManager.ipManager.repositories.interfaces

import com.ipManager.ipManager.repositories.entities.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<MemberEntity, Long> {
    fun findByEmail(email: String): MemberEntity?
    fun findByApiId(memerId: String): MemberEntity?
}