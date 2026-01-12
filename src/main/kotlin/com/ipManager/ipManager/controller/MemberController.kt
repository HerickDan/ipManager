package com.ipManager.ipManager.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController {
    @PostMapping
    fun helloWorld(): String{
        return "Hello World"
    }
}