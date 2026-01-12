package com.ipManager.ipManager.controller

import com.ipManager.ipManager.services.MemberService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController(private val memberService: MemberService) {
    @PostMapping
    fun helloWorld(): String {
        return "Hello World"
    }
}