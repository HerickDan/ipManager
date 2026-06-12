package com.ipManager.ipManager.repositories.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.ZonedDateTime
import java.util.UUID

@Entity
@Table(name="basket_distro")
data class BasketDistroEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long ?= null,
    val apiId: String ? = UUID.randomUUID().toString(),
    val quantity: Int,
    val distributedIn: ZonedDateTime ?= ZonedDateTime.now(),
    val adminName: String,
    @ManyToOne
    @JoinColumn("beneficiary_id")
    val beneficiary: BeneficiariesEntity,
    val moreThanOne: Boolean ? = false,
    val justify: String ? = null,
)