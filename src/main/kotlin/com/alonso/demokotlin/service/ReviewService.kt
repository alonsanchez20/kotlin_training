package com.alonso.demokotlin.service

import com.alonso.demokotlin.exception.ProductNotFoundByIdException
import com.alonso.demokotlin.model.entity.Product
import com.alonso.demokotlin.model.entity.Review
import com.alonso.demokotlin.model.request.ReviewRequest
import com.alonso.demokotlin.model.response.ReviewResponse
import com.alonso.demokotlin.repository.ProductRepository
import com.alonso.demokotlin.repository.ReviewRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class ReviewService(
    final val reviewRepository: ReviewRepository,
    final val productRepository: ProductRepository,
) {
    fun save(
        reviewRequest: ReviewRequest,
        productId: Long,
    ): ReviewResponse {
        val product: Optional<Product?> = productRepository.findById(productId)

        if (product.isEmpty) {
            throw ProductNotFoundByIdException(productId)
        }

        val review =
            Review(
                id = null,
                comment = reviewRequest.comment,
                product = product.get(),
            )
        reviewRepository.save(review)

        val response =
            ReviewResponse(
                id = review.id,
                comment = review.comment,
                product = product.get(),
            )
        return response
    }

    fun findReviewsByProductId(productId: Long): List<ReviewResponse> {
        val reviews = reviewRepository.findByProductId(productId)
        return reviews.map { review ->
            ReviewResponse(
                id = review.id,
                comment = review.comment,
            )
        }
    }
}
