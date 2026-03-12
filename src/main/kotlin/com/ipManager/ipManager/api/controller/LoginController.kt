package com.ipManager.ipManager.api.controller

import com.ipManager.ipManager.api.dto.LoginRequestDto
import com.ipManager.ipManager.api.responses.LoginResponseDto
import com.ipManager.ipManager.services.Authentication.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class LoginController(
    private val service: AuthService
) {
    @PostMapping
    fun doLogin(
        @RequestBody login: LoginRequestDto
    ): LoginResponseDto {
        return service.login(login)
    }
}