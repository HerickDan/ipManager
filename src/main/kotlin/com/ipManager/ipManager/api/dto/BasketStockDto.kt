package com.ipManager.ipManager.api.dto

import com.ipManager.ipManager.repositories.entities.BasketEntity
import java.time.ZonedDateTime

data class BasketStockDto(
    val apiId: String?,
    val quantity: Int,
    val updatedAt: ZonedDateTime?
) {
    companion object {
        fun fromEntity(entity: BasketEntity) = BasketStockDto(
            apiId = entity.apiId,
            quantity = entity.quantity,
            updatedAt = entity.updatedAt
        )
    }
}
