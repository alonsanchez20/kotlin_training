package com.alonso.demokotlin.controller

import com.alonso.demokotlin.model.entity.ElectronicProduct
import com.alonso.demokotlin.service.ElectronicProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/electronic-products")
class ElectronicProductController(
    private val electronicProductService: ElectronicProductService,
) {
    @GetMapping
    fun findAll(): ResponseEntity<List<ElectronicProduct>> = ResponseEntity.ok(electronicProductService.findAll())

    @GetMapping("/{id}")
    fun findById(
        @PathVariable id: Long,
    ): ResponseEntity<ElectronicProduct> = ResponseEntity.ok(electronicProductService.findById(id))

    @PostMapping
    fun add(
        @RequestBody electronicProduct: ElectronicProduct,
    ): ResponseEntity<ElectronicProduct> {
        electronicProductService.save(electronicProduct)
        return ResponseEntity.ok(electronicProduct)
    }
}
