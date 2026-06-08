package com.ipManager.ipManager.services

import com.ipManager.ipManager.api.dto.AdminDto
import com.ipManager.ipManager.commons.errorMessages.ErrorMessages
import com.ipManager.ipManager.config.Exceptions.BadRequestException
import com.ipManager.ipManager.repositories.entities.MemberEntity
import com.ipManager.ipManager.repositories.interfaces.MemberRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private var passwordEncoder: PasswordEncoder
) {
    fun createMember(adminDto: AdminDto) {
        passwordEncoder = BCryptPasswordEncoder()
        val encodedPassword = passwordEncoder.encode(adminDto.password)
        val memberEntity = MemberEntity(
            firstName = adminDto.firstName,
            lastName = adminDto.lastName,
            password = encodedPassword.toString(),
            email = adminDto.email
        )
        try {
            memberRepository.save(memberEntity)
        }catch (e: Exception){
            throw BadRequestException(ErrorMessages.NOT_FOUND_EXCEPTION)
        }
    }
}