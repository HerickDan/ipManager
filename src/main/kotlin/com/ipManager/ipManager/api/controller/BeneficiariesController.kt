package com.ipManager.ipManager.api.controller

import com.ipManager.ipManager.api.dto.ReadBeneficiariesDto
import com.ipManager.ipManager.api.requests.CreateBeneficiariesRequest
import com.ipManager.ipManager.api.requests.UpdateUserInfoRequest
import com.ipManager.ipManager.services.BeneficiariesService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@Tag(name = "Beneficiaries")
@RequestMapping("/beneficiaries")
class BeneficiariesController(
    val service: BeneficiariesService
) {
    @Operation(summary = "Add beneficiary")
    @PostMapping
    fun createBeneficiary(
        @RequestBody request: CreateBeneficiariesRequest
    ) {
        service.createBeneficiary(
            request.toDto()
        )
    }

    @Operation(summary = "Find All Beneficiaries")
    @GetMapping()
    fun getAll(
        @RequestParam(required = false)
        active: Boolean ? = true
    ): List<ReadBeneficiariesDto> = service.findAllBeneficiaries(active!!)

    @Operation(summary = "Disable beneficiary")
    @DeleteMapping("/{id}")
    fun disableBeneficiary(
        @PathVariable id: String
    ) {
        service.disableBeneficiary(id)
    }
    @Operation(summary = "Active beneficiary")
    @PatchMapping("/active/{id}")
    fun activeBeneficiary(
        @PathVariable id: String
    ) {
        service.activeBeneficiary(id)
    }

    @Operation(summary = "Update beneficiary")
    @PatchMapping("/{id}")
    fun updateUserInfo(
        @PathVariable id: String,
        @RequestBody req: UpdateUserInfoRequest
    ) {
        service.updateUserInfo(id, req.toDto())
    }


    @Operation(summary = "Find beneficiary")
    @GetMapping("/{id}")
    fun findBeneficiaryById(
        @PathVariable id: String
    ): ReadBeneficiariesDto {
        return service.findBeneficiaryById(id)
    }
}