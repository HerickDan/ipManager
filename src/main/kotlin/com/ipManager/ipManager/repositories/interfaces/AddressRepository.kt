package com.ipManager.ipManager.repositories.interfaces

import com.ipManager.ipManager.repositories.entities.AddressEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository: JpaRepository<AddressEntity, Long> {

}