package com.ipManager.ipManager.repositories.entities

import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "Address")
data class AddressEntity (
    val name: String,
    val complement: String? = null,
    val number: Int,
    @OneToOne
    @JoinColumn("member_id")
    val residentEntity: BeneficiarieEntity
)