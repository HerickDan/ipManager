package com.ipManager.ipManager.api.controller

import com.ipManager.ipManager.api.dto.RegisterDistroDto
import com.ipManager.ipManager.services.BasketDistroService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/distributions")
class BasketDistroController(
    private val basketDistroService: BasketDistroService,
) {
    @PostMapping
    fun register(@RequestBody request: RegisterDistroDto) {
        basketDistroService.register(request)
    }
}
