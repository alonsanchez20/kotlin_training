package com.alonso.demokotlin.repository

import com.alonso.demokotlin.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
interface ProductRepository : JpaRepository<Product, BigInteger> {
}