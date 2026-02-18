    package com.ipManager.ipManager.services.Authentication

    import com.ipManager.ipManager.commons.dto.LoginRequestDto
    import com.ipManager.ipManager.commons.responses.LoginResponseDto
    import jakarta.servlet.http.HttpServletRequest
    import org.springframework.security.authentication.AuthenticationManager
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
    import org.springframework.security.core.context.SecurityContextHolder
    import org.springframework.stereotype.Service
    import java.net.http.HttpRequest
    import java.net.http.HttpResponse

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

            SecurityContextHolder.getContext().authentication = auth
            return LoginResponseDto(
                auth.name,
                auth.authorities.first().authority.toString()
            )
        }

        fun logout(req: HttpServletRequest) {
            req.session?.invalidate()
            SecurityContextHolder.clearContext()
        }
    }