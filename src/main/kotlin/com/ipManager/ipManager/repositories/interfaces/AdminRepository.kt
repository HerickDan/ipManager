package com.ipManager.ipManager.repositories.interfaces

import com.ipManager.ipManager.repositories.entities.AdminEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AdminRepository: JpaRepository<AdminEntity, Long> {
    fun findByEmail(email: String): AdminEntity?
    fun findByApiId(adminId: String): AdminEntity?
}