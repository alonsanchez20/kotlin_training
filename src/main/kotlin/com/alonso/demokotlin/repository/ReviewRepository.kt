package com.alonso.demokotlin.repository

import com.alonso.demokotlin.model.entity.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : JpaRepository<Review, Long> {
    fun findByProductId(productId: Long): List<Review>
}
