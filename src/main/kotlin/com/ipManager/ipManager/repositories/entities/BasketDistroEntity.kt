package com.ipManager.ipManager.repositories.entities

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
    val updatedAt: ZonedDateTime ?= ZonedDateTime.now(),
    @ManyToOne
    @JoinColumn("member_id")
    val member: MemberEntity,
    val moreThanOne: Boolean ? = false,
    val justify: String ? = null,
)