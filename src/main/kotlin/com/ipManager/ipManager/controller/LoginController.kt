package com.ipManager.ipManager.controller

import com.ipManager.ipManager.commons.dto.LoginRequestDto
import com.ipManager.ipManager.commons.responses.LoginResponseDto
import com.ipManager.ipManager.services.Authentication.AuthService
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
class LoginController(
    private val service: AuthService
) {
    @PostMapping
    fun login(
        @RequestBody login: LoginRequestDto
    ): LoginResponseDto {
        return service.login(login)
    }
}