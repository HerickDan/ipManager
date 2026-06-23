package com.ipManager.ipManager.api.controller

import com.ipManager.ipManager.api.requests.LoginRequest
import com.ipManager.ipManager.api.responses.LoginResponse
import com.ipManager.ipManager.services.Authentication.AuthService
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name="Authentication")
@RequestMapping("/auth")
class LoginController(
    private val service: AuthService
) {
    @PostMapping
    fun doLogin(
        @RequestBody request: LoginRequest,
        req: HttpServletRequest,
        resp: HttpServletResponse
    ): LoginResponse {
        val info = service.login(request.toDto(), req, resp)
        return LoginResponse(email = info.email, role = info.role)
    }
}