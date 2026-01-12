package com.ipManager.ipManager.services

import com.ipManager.ipManager.commons.dto.MemberDto
import com.ipManager.ipManager.repositories.interfaces.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
   private val memberRepository: MemberRepository
) {
    fun createMember(memberDto: MemberDto){
        //memberRepository.save()
    }
}