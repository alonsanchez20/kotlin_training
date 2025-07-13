package com.alonso.demokotlin.service

import com.alonso.demokotlin.model.entity.ElectronicProduct
import com.alonso.demokotlin.repository.ElectronicProductRepository
import org.springframework.stereotype.Service

@Service
class ElectronicProductService(
    private val electronicProductRepository: ElectronicProductRepository,
) {
    fun save(electronicProduct: ElectronicProduct) {
        electronicProductRepository.save(electronicProduct)
    }

    fun findAll(): List<ElectronicProduct> = electronicProductRepository.findAll()

    fun findById(id: Long): ElectronicProduct =
        electronicProductRepository.findById(id).orElseThrow { RuntimeException("ElectronicProduct with id $id not found") }
}
