package com.alonso.demokotlin.repository

import com.alonso.demokotlin.model.entity.ElectronicProduct
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ElectronicProductRepository : JpaRepository<ElectronicProduct, Long>
