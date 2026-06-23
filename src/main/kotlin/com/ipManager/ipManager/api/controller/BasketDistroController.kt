package com.ipManager.ipManager.api.controller

import com.ipManager.ipManager.api.requests.RegisterDistroRequest
import com.ipManager.ipManager.api.responses.ReadDistributionResponse
import com.ipManager.ipManager.services.BasketDistroService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/distributions")
@Tag(name = "Basket journey")
class BasketDistroController(
    private val basketDistroService: BasketDistroService,
) {
    @Operation(summary = "Find all distributions by month and year")
    @GetMapping
    fun findAll(
        @RequestParam(required = false) month: Int?,
        @RequestParam(required = false) year: Int?,
    ): List<ReadDistributionResponse> =
        basketDistroService.findAll(month = month, year = year).map { ReadDistributionResponse.fromDto(it) }

    @Operation(summary = "Register distribution")
    @PostMapping
    fun register(@RequestBody request: RegisterDistroRequest) {
        basketDistroService.register(request.toDto())
    }
}
