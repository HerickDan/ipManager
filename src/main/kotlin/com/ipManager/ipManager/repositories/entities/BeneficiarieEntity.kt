package com.ipManager.ipManager.repositories.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Table(name = "beneficiaries")
@Entity
data class BeneficiariesEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val apiId: String? = UUID.randomUUID().toString(),
    val firstName: String,
    val lastName: String,
    val familyMembersNumber: Int? = 0,
    val active: Boolean? = true
)