package com.ipManager.ipManager.api.controller

import com.ipManager.ipManager.repositories.entities.BasketEntity
import com.ipManager.ipManager.services.BasketStockService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/baskets/stock")
@Tag(name = "Basket journey")
class BasketStockController(
    private val basketStockService: BasketStockService,
) {
    @Operation(summary = "Add baskets to stock")
    @PostMapping("/{quantity}")
    @ResponseStatus(HttpStatus.CREATED)
    fun addStock(@PathVariable quantity: Int?) {
        val quantity = quantity ?: throw IllegalArgumentException("quantity is required")
        basketStockService.addStock(quantity)
    }

    @Operation(summary = "Return basket quantity")
    @GetMapping
    fun getStock(): BasketEntity? {
        return basketStockService.getCurrentStock()
    }
}
