package com.alonso.demokotlin.controller

import com.alonso.demokotlin.model.Product
import com.alonso.demokotlin.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger

@RestController
@RequestMapping(path = ["/api/v1/data"])
class AppController(private val productService: ProductService) {


    @GetMapping
    fun index(@RequestParam("name") name: String) = "Hello, $name!"


    @GetMapping("/products/{id}")
    fun findProductById(@PathVariable id: BigInteger): ResponseEntity<Product> {
        val product = productService.findById(id)
        return ResponseEntity.ok(product)
    }

    @PostMapping("/products")
    fun addProduct(@RequestBody product: Product): ResponseEntity<Product> {
        productService.save(product);
        return ResponseEntity.ok(product);
    }


}