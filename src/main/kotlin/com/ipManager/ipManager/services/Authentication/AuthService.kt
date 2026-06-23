package com.ipManager.ipManager.services.Authentication

import com.ipManager.ipManager.api.dto.LoginDto
import com.ipManager.ipManager.api.dto.LoginInfoDto
import com.ipManager.ipManager.commons.errorMessages.ErrorMessages
import com.ipManager.ipManager.config.Exceptions.NotFoundException
import com.ipManager.ipManager.repositories.interfaces.AdminRepository
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.context.HttpSessionSecurityContextRepository
import org.springframework.stereotype.Service
import javax.naming.AuthenticationException

@Service
class AuthService(
    private val authManger: AuthenticationManager,
    private val adminRepository: AdminRepository
) {

    private val securityContextRepository =
        HttpSessionSecurityContextRepository()

    fun login(
        login: LoginDto,
        request: HttpServletRequest,
        response: HttpServletResponse
    ): LoginInfoDto {
        adminRepository.findByEmail(login.email)
            ?: throw NotFoundException(ErrorMessages.NOT_FOUND_EXCEPTION)

        return try {
            val auth = authManger.authenticate(
                UsernamePasswordAuthenticationToken(
                    login.email,
                    login.password
                )
            )

            val context = SecurityContextHolder.createEmptyContext()
            context.authentication = auth

            SecurityContextHolder.setContext(context)

            request.getSession(true)

            securityContextRepository.saveContext(
                context,
                request,
                response
            )

            LoginInfoDto(
                auth.name,
                auth.authorities.first().authority.toString()
            )

        } catch (ex: AuthenticationException) {
            throw BadCredentialsException("Invalid email or password")
        }
    }

    fun logout(req: HttpServletRequest) {
        req.session?.invalidate()
        SecurityContextHolder.clearContext()
    }
}