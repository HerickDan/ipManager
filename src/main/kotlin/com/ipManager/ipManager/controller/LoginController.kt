package com.ipManager.ipManager.controller

import com.ipManager.ipManager.commons.dto.LoginRequestDto
import com.ipManager.ipManager.commons.responses.LoginResponseDto
import com.ipManager.ipManager.services.Authentication.AuthService
import org.springframework.web.bind.annotation.GetMapping
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

    @GetMapping("/hello")
    fun hello(): String{
        return "HELLO MOTHERFUCER"
    }

}