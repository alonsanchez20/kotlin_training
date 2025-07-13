package com.alonso.demokotlin.model.response

import com.alonso.demokotlin.model.entity.Product

data class ReviewResponse(
    val id: Long? = null,
    val comment: String,
    val product: Product? = null,
)
