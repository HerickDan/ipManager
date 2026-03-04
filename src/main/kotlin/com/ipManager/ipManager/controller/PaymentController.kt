package com.ipManager.ipManager.controller

import com.ipManager.ipManager.services.PaymentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/payment")
class PaymentController (
    private val paymentService: PaymentService
){
    @GetMapping
    fun getCode(): String{
        return paymentService.generatePix()
    }
}