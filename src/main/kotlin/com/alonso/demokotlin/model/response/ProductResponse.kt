package com.alonso.demokotlin.model.response

import com.alonso.demokotlin.model.entity.Review

data class ProductResponse(
    val id: Long? = null,
    val name: String,
    val price: Double,
    val reviews: List<Review> = mutableListOf(),
)
