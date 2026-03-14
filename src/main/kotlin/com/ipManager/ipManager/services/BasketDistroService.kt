package com.ipManager.ipManager.services

import com.ipManager.ipManager.repositories.entities.BasketEntity
import com.ipManager.ipManager.repositories.interfaces.BasketDistroRepository
import com.ipManager.ipManager.repositories.interfaces.BasketStockRepository
import com.ipManager.ipManager.repositories.interfaces.MemberRepository
import org.springframework.stereotype.Service

@Service
class BasketDistroService(
    private val basketRepository: BasketStockRepository,
    private val distroRepository: BasketDistroRepository,
    private val memberRepository: MemberRepository
) {
    fun register(memberId: String) {
        val member = memberRepository.findByApiId(memberId)
        if (member != null && baskets()!=null) {

        }
    }

    private fun baskets(): BasketEntity? {
        val basket = basketRepository.findAll().first()
        return if (basket.quantity > 0) {
            basket
        } else {
            null
        }
    }
}