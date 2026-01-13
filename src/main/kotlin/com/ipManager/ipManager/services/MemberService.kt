package com.ipManager.ipManager.services

import com.ipManager.ipManager.commons.dto.MemberDto
import com.ipManager.ipManager.repositories.entities.MemberEntity
import com.ipManager.ipManager.repositories.interfaces.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
   private val memberRepository: MemberRepository
) {
    fun createMember(memberDto: MemberDto){
        val memberEntity = MemberEntity(
            firstName = memberDto.firstName,
            lastName = memberDto.lastName,
            password = memberDto.password,
            email = memberDto.email
        )

        memberRepository.save(memberEntity)
    }
}