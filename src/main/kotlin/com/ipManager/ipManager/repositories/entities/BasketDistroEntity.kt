package com.ipManager.ipManager.repositories.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.ZonedDateTime

@Entity
@Table(name="")
data class BasketDistroEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long ?= null,
    val apiId: String ? = null,
    val quantity: Int,
    val updatedAt: ZonedDateTime ?= ZonedDateTime.now(),
    @Column("member_id")
    val member: MemberEntity,
    val moreThanOne: Boolean ? = false,
    val justify: String ? = null,
)