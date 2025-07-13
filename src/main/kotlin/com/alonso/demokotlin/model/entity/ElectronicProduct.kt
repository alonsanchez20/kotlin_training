package com.alonso.demokotlin.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "electronic_product")
class ElectronicProduct(
    id: Long? = null,
    name: String,
    price: Double,
    @Column(nullable = false)
    val warrantyMonths: Int,
) : Product(id = id, name = name, price = price)
