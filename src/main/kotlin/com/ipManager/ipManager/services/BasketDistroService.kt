package com.ipManager.ipManager.services

import com.ipManager.ipManager.api.dto.RegisterDistroDto
import com.ipManager.ipManager.commons.errorMessages.ErrorMessages
import com.ipManager.ipManager.config.Exceptions.ConflictException
import com.ipManager.ipManager.config.Exceptions.NotFoundException
import com.ipManager.ipManager.repositories.entities.BasketDistroEntity
import com.ipManager.ipManager.repositories.entities.BasketEntity
import com.ipManager.ipManager.repositories.interfaces.BasketDistroRepository
import com.ipManager.ipManager.repositories.interfaces.BasketStockRepository
import com.ipManager.ipManager.repositories.interfaces.MemberRepository
import org.springframework.stereotype.Service
import java.time.ZonedDateTime

@Service
class BasketDistroService(
    private val basketRepository: BasketStockRepository,
    private val distroRepository: BasketDistroRepository,
    private val memberRepository: MemberRepository
) {
    fun register(dto: RegisterDistroDto) {
        // Will look for the member on the database
        val member =
            memberRepository.findByApiId(dto.memberId) ?: throw NotFoundException(ErrorMessages.NOT_FOUND_EXCEPTION)
        // will look form some basket in the database
        val basketQuantity = baskets() ?: throw NotFoundException(ErrorMessages.BASKETS_NOT_FOUND)
        val date = ZonedDateTime.now()
        val distributedBasket = distroRepository.findByMemberAndMonthAndYear(
            member,
            month = date.monthValue,
            year = date.year,
        )

        if (dto.quantity!! > basketQuantity.quantity) {
            throw ConflictException(ErrorMessages.QUANTITY_EXCEEDS)
        }

        baskets()?.quantity.let { it ->
            if (distributedBasket.size <= 2) {
                distroRepository.save(
                    BasketDistroEntity(
                        quantity = dto.quantity,
                        member = member,
                        moreThanOne = dto.moreThanOne,
                        justify = dto.justify
                    )
                )
            }
        }
    }

    // will look form some basket in the database
    private fun baskets(): BasketEntity? {
        val basket = basketRepository.findAll().first()
        return if (basket.quantity > 0) {
            basket
        } else {
            null
        }
    }
}