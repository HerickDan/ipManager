package com.ipManager.ipManager.config

import com.ipManager.ipManager.commons.errorMessages.ErrorMessages
import com.ipManager.ipManager.config.GlobalException.NotFoundException
import com.ipManager.ipManager.repositories.interfaces.MemberRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service


@Service
class CustomUserDetails(
    private val memberRepository: MemberRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        println("userEmail" + username)
        val user = memberRepository.findByEmail(username)
            ?: throw NotFoundException(
                ErrorMessages.NOT_FOUND_EXCEPTION
            )
        val authorities = listOf(user.role!!.toGrantedAuthority())
        return User(
            user.email,
            user.password,
            authorities,
        )
    }
}