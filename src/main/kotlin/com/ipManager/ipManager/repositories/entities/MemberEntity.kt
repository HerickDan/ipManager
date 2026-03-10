package com.ipManager.ipManager.repositories.entities

import com.ipManager.ipManager.commons.enums.Role
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name= "member")
data class MemberEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long ?= null,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    @Enumerated(EnumType.STRING)
    val role: Role ?= Role.COMMON
)
