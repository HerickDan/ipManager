package com.ipManager.ipManager.api.controller

import com.ipManager.ipManager.api.requests.CreateBeneficiariesRequest
import com.ipManager.ipManager.services.BeneficiariesService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/beneficiaries")
class BeneficiariesController(
    val service: BeneficiariesService
) {
    @PostMapping
    fun createBeneficiary(
        @RequestBody request: CreateBeneficiariesRequest
    ){
        service.createBeneficiary(
            request.toDto()
        )
    }
}