package com.alonso.demokotlin.service

import com.alonso.demokotlin.exception.ProductNotFoundByIdException
import com.alonso.demokotlin.model.entity.Product
import com.alonso.demokotlin.model.response.ProductResponse
import com.alonso.demokotlin.repository.ProductRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class ProductService(
    final val productRepository: ProductRepository,
) {
    fun save(product: Product) {
        productRepository.save(product)
    }

    fun findAll(): List<Product> = productRepository.findAll()

    @Cacheable(value = ["products"], key = "#id")
    fun findById(id: Long): ProductResponse {
        val product =
            productRepository
                .findById(id)
                .orElseThrow { ProductNotFoundByIdException(id) }

        return ProductResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            reviews = product.reviews,
        )
    }
}
