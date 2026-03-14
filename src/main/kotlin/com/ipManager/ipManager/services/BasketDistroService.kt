package com.ipManager.ipManager.services

import com.ipManager.ipManager.api.dto.RegisterDistroDto
import com.ipManager.ipManager.repositories.entities.BasketDistroEntity
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
    fun register(dto: RegisterDistroDto) {
        val member = memberRepository.findByApiId(dto.memberId)
        if (member != null && baskets()!=null) {
            distroRepository.save(
                BasketDistroEntity(
                    quantity = dto.quantity!!,
                    member = member,
                    moreThanOne = dto.moreThanOne,
                    justify =  dto.justify
                )
            )
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