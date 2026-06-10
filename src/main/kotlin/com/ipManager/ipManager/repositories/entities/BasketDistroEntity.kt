package com.ipManager.ipManager.repositories.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.ZonedDateTime

@Entity
@Table(name="basket_distro")
data class BasketDistroEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long ?= null,
    val apiId: String ? = null,
    val quantity: Int,
    val distributedIn: ZonedDateTime ?= ZonedDateTime.now(),
    @ManyToOne
    @JoinColumn("admin_id")
    val admin: AdminEntity,
    @ManyToOne
    @JoinColumn("beneficiary_id")
    val beneficiary: BeneficiariesEntity,
    val moreThanOne: Boolean ? = false,
    val justify: String ? = null,
)