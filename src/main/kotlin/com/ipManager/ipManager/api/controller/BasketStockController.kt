package com.ipManager.ipManager.api.controller

import com.ipManager.ipManager.repositories.entities.BasketEntity
import com.ipManager.ipManager.services.BasketStockService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/baskets/stock")
class BasketStockController(
    private val basketStockService: BasketStockService,
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addStock(@RequestBody request: Map<String, Int>) {
        val quantity = request["quantity"] ?: throw IllegalArgumentException("quantity is required")
        basketStockService.addStock(quantity)
    }

    @GetMapping
    fun getStock(): BasketEntity? {
        return basketStockService.getCurrentStock()
    }
}
