package com.alonso.demokotlin.service

import com.alonso.demokotlin.exception.ProductNotFoundException
import com.alonso.demokotlin.model.Product
import com.alonso.demokotlin.repository.ProductRepository
import org.springframework.stereotype.Service
import java.math.BigInteger

@Service
class ProductService (final val productRepository: ProductRepository){

    fun save(product: Product) {
        productRepository.save(product)
    }

    fun findAll(): List<Product> = productRepository.findAll();

    fun findById(id: BigInteger): Product? {
        return productRepository.findById(id).orElseThrow { ProductNotFoundException(id) }
    }

}