package com.ipManager.ipManager.repositories.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.ZonedDateTime
import java.util.UUID

@Entity
@Table(name="basket_stock")
data class BasketEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long ?= null,
    val apiId: String? = UUID.randomUUID().toString(),
    var quantity: Int,
    val updatedAt: ZonedDateTime ? = ZonedDateTime.now()
)
