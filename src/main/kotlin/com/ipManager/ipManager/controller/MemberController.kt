package com.ipManager.ipManager.controller

import com.ipManager.ipManager.api.dto.MemberResponseDto
import com.ipManager.ipManager.api.requests.CreateMemberRequest
import com.ipManager.ipManager.repositories.interfaces.MemberRepository
import com.ipManager.ipManager.services.MemberService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController(private val memberService: MemberService) {

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @RequestBody request: CreateMemberRequest
    ) {
        memberService.createMember(request.toDto())
    }

    @GetMapping("/{memberId}")
    fun getMemberById(
        @PathVariable memberId: String,
    ): MemberResponseDto{
        return memberService.getMemberById(memberId)
    }

    @DeleteMapping("/{memberId}")
    fun deleteMember(
        @PathVariable memberId: String
    ){
        memberService.deleteMember(memberId)
    }

}