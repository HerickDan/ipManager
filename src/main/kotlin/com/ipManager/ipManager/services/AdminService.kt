package com.ipManager.ipManager.services

import com.ipManager.ipManager.api.dto.AdminDto
import com.ipManager.ipManager.commons.errorMessages.ErrorMessages
import com.ipManager.ipManager.config.Exceptions.BadRequestException
import com.ipManager.ipManager.repositories.entities.AdminEntity
import com.ipManager.ipManager.repositories.interfaces.AdminRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AdminService(
    private val adminRepository: AdminRepository,
    private var passwordEncoder: PasswordEncoder = BCryptPasswordEncoder()
) {
    fun createAdmin(adminDto: AdminDto) {
        val encodedPassword = passwordEncoder.encode(adminDto.password)
        val adminEntity = AdminEntity(
            firstName = adminDto.firstName,
            lastName = adminDto.lastName,
            password = encodedPassword.toString(),
            email = adminDto.email
        )
        try {
            adminRepository.save(adminEntity)
        }catch (e: Exception){
            throw BadRequestException(ErrorMessages.NOT_FOUND_EXCEPTION)
        }
    }
}