package com.ipManager.ipManager.api.responses

import com.ipManager.ipManager.api.dto.BasketStockDto

data class BasketStockResponse(
    val apiId: String?,
    val quantity: Int,
    val updatedAt: String?
) {
    companion object {
        fun fromDto(dto: BasketStockDto) = BasketStockResponse(
            apiId = dto.apiId,
            quantity = dto.quantity,
            updatedAt = dto.updatedAt?.toString()
        )
    }
}
