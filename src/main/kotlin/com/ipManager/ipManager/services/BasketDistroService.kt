package com.ipManager.ipManager.services

import com.ipManager.ipManager.api.dto.RegisterDistroDto
import com.ipManager.ipManager.commons.errorMessages.ErrorMessages
import com.ipManager.ipManager.config.Exceptions.BadRequestException
import com.ipManager.ipManager.config.Exceptions.ConflictException
import com.ipManager.ipManager.config.Exceptions.NotFoundException
import com.ipManager.ipManager.repositories.entities.BasketDistroEntity
import com.ipManager.ipManager.repositories.entities.BasketEntity
import com.ipManager.ipManager.repositories.interfaces.BasketDistroRepository
import com.ipManager.ipManager.repositories.interfaces.BasketStockRepository
import com.ipManager.ipManager.repositories.interfaces.BeneficiariesRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import java.time.ZonedDateTime

@Service
class BasketDistroService(
    private val basketRepository: BasketStockRepository,
    private val distroRepository: BasketDistroRepository,
    private val beneficiariesRepository: BeneficiariesRepository,
) {
    fun register(dto: RegisterDistroDto) {
        val adminName = SecurityContextHolder.getContext().authentication?.name
            ?: throw BadRequestException(ErrorMessages.BAD_REQUEST_EXCEPTION)

        val beneficiary = beneficiariesRepository.findByApiId(dto.beneficiaryId)
            ?: throw NotFoundException(ErrorMessages.NOT_FOUND_EXCEPTION)

        val basket = baskets() ?: throw NotFoundException(ErrorMessages.BASKETS_NOT_FOUND)

        val quantity = dto.quantity ?: throw BadRequestException(ErrorMessages.BAD_REQUEST_EXCEPTION)

        if (quantity > basket.quantity) {
            throw ConflictException(ErrorMessages.QUANTITY_EXCEEDS)
        }

        val date = ZonedDateTime.now()
        val distributedBasket = distroRepository.findByAdminNameAndMonthAndYear(
            adminName = adminName,
            month = date.monthValue,
            year = date.year,
        )

        if (distributedBasket.size >= 2) {
            throw ConflictException(ErrorMessages.MONTHLY_LIMIT_EXCEEDED)
        }

        distroRepository.save(
            BasketDistroEntity(
                quantity = quantity,
                adminName = adminName,
                beneficiary = beneficiary,
                moreThanOne = dto.moreThanOne,
                justify = dto.justify
            )
        )

        basketRepository.save(basket.copy(quantity = basket.quantity - quantity))
    }

    private fun baskets(): BasketEntity? {
        val all = basketRepository.findAll()
        if (all.isEmpty()) return null
        val basket = all.first()
        return if (basket.quantity > 0) basket else null
    }
}
