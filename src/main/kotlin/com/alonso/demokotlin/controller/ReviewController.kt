@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.alonso.demokotlin.controller

import com.alonso.demokotlin.model.request.ReviewRequest
import com.alonso.demokotlin.model.response.ReviewResponse
import com.alonso.demokotlin.service.ReviewService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class ReviewController(
    private val reviewService: ReviewService,
) {
    @PostMapping("/products/{productId}/reviews")
    fun add(
        @PathVariable productId: Long,
        @RequestBody reviewRequest: ReviewRequest,
    ): ResponseEntity<ReviewResponse> = ResponseEntity.ok(reviewService.save(reviewRequest, productId))

    @GetMapping("/products/{productId}/reviews")
    fun findReviewsByProductId(
        @PathVariable productId: Long,
    ): ResponseEntity<List<ReviewResponse>> = ResponseEntity.ok(reviewService.findReviewsByProductId(productId))
}
