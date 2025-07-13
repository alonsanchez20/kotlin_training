package com.alonso.demokotlin.model.request

import com.alonso.demokotlin.model.entity.Review

data class ProductRequest(
    val name: String,
    val price: Double,
    val reviews: List<Review> = mutableListOf(),
)
