package com.ipManager.ipManager.services

import com.ipManager.ipManager.api.dto.MemberDto
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
    fun createMember(memberDto: MemberDto) {
        passwordEncoder = BCryptPasswordEncoder()
        val encodedPassword = passwordEncoder.encode(memberDto.password)
        val memberEntity = MemberEntity(
            firstName = memberDto.firstName,
            lastName = memberDto.lastName,
            password = encodedPassword.toString(),
            email = memberDto.email
        )
        try {
            memberRepository.save(memberEntity)
        }catch (e: Exception){
            throw BadRequestException(ErrorMessages.NOT_FOUND_EXCEPTION)
        }
    }
}