package com.ipManager.ipManager.api.controller

import com.ipManager.ipManager.api.requests.CreateAdminRequest
import com.ipManager.ipManager.services.AdminService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
class AdminController(private val adminService: AdminService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @RequestBody request: CreateAdminRequest
    ) {
        adminService.createAdmin(request.toDto())
    }
}