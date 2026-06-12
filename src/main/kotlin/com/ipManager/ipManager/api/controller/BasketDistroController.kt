package com.ipManager.ipManager.api.controller

import com.ipManager.ipManager.api.dto.RegisterDistroDto
import com.ipManager.ipManager.services.BasketDistroService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/distributions")
@Tag(name = "Basket journey")
class BasketDistroController(
    private val basketDistroService: BasketDistroService,
) {
    @Operation(summary = "")
    @PostMapping
    fun register(@RequestBody request: RegisterDistroDto) {
        basketDistroService.register(request)
    }
}
