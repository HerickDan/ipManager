package com.ipManager.ipManager.repositories.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "cellphone")
data class CellPhoneEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val countryCode: Int,
    val ddd: Int,
    val prefixLine: Int,
    @OneToOne
    @JoinColumn(name = "phone_owner", referencedColumnName = "id")
    val phoneOwner: BeneficiariesEntity
)
