package com.alonso.demokotlin.model

import jakarta.persistence.*
import java.math.BigInteger

@Entity
@Table(name = "product")
data class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSeqGen")
    @SequenceGenerator(name = "productSeqGen", sequenceName = "product_id_seq", allocationSize = 1)
    val id: BigInteger?,

    @Column(unique = true, nullable = false)
    val name: String,

    @Column(nullable = false)
    val price: Int
)
