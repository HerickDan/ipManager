package com.ipManager.ipManager.repositories.interfaces

import com.ipManager.ipManager.repositories.entities.BasketEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BasketDistroRepository: JpaRepository<Long, BasketEntity> {
}