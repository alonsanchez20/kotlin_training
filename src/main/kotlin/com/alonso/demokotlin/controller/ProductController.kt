package com.alonso.demokotlin.controller

import com.alonso.demokotlin.model.entity.Product
import com.alonso.demokotlin.model.response.ProductResponse
import com.alonso.demokotlin.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/api/v1/products"])
class ProductController(
    private val productService: ProductService,
) {
    @GetMapping
    fun findAllProducts(): ResponseEntity<List<Product>> = ResponseEntity.ok(productService.findAll())

    @GetMapping("/{id}")
    fun findProductById(
        @PathVariable id: Long,
    ): ResponseEntity<ProductResponse> {
        val product = productService.findById(id)
        return ResponseEntity.ok(product)
    }

    @PostMapping
    fun addProduct(
        @RequestBody product: Product,
    ): ResponseEntity<Product> {
        productService.save(product)
        return ResponseEntity.ok(product)
    }
}
