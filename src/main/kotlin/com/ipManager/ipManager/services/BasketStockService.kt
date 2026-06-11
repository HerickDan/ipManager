package com.ipManager.ipManager.services

import com.ipManager.ipManager.repositories.entities.BasketEntity
import com.ipManager.ipManager.repositories.interfaces.BasketStockRepository
import org.springframework.stereotype.Service
import java.time.ZonedDateTime

@Service
class BasketStockService(
    private val basketRepository: BasketStockRepository,
) {
    fun addStock(quantity: Int) {
        val existing = basketRepository.findAll().firstOrNull()
        basketRepository.save(existing?.copy(quantity = existing.quantity + quantity, updatedAt = ZonedDateTime.now()))

    }

    fun getCurrentStock(): BasketEntity? {
        return basketRepository.findAll().firstOrNull()
    }
}
