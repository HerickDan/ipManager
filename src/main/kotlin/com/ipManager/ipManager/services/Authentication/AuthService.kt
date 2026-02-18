package com.ipManager.ipManager.services.Authentication

import com.ipManager.ipManager.commons.dto.LoginRequestDto
import com.ipManager.ipManager.commons.responses.LoginResponseDto
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val authManger: AuthenticationManager
) {
    fun login(login: LoginRequestDto): LoginResponseDto {
        val auth = authManger.authenticate(
            UsernamePasswordAuthenticationToken(
                login.email,
                login.password
            )
        )

        println("user=${auth.name}")
        println("roles=${auth.authorities.map { it.authority }}")
        SecurityContextHolder.getContext().authentication = auth
        return LoginResponseDto(
            auth.name,
            auth.authorities.toList()
        )
    }
}