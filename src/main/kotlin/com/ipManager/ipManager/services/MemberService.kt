package com.ipManager.ipManager.services

import com.ipManager.ipManager.api.dto.CreateMemberDto
import com.ipManager.ipManager.api.dto.MemberResponseDto
import com.ipManager.ipManager.commons.errorMessages.ErrorMessages
import com.ipManager.ipManager.config.GlobalException.NotFoundException
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
    fun createMember(memberDto: CreateMemberDto) {
        passwordEncoder = BCryptPasswordEncoder()
        val encodedPassword = passwordEncoder.encode(memberDto.password)
        val memberEntity = MemberEntity(
            firstName = memberDto.firstName,
            lastName = memberDto.lastName,
            password = encodedPassword.toString(),
            email = memberDto.email
        )
        memberRepository.save(memberEntity)
    }

    fun getMemberById(memberId: String): MemberResponseDto{
        val member = memberRepository.findByApiId(memberId) ?: throw NotFoundException(ErrorMessages.NOT_FOUND_EXCEPTION)
        return MemberResponseDto(
            id = member.apiId!!,
            firstName = member.firstName,
            lastName = member.lastName,
            email = member.email
        )
    }

    fun deleteMember(memberId: String){
        val member = memberRepository.findByApiId(memberId) ?: throw NotFoundException(ErrorMessages.NOT_FOUND_EXCEPTION)
        memberRepository.delete(member)
    }
}