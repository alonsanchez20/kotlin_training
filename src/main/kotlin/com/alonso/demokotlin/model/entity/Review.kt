package com.alonso.demokotlin.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "review")
class Review(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false)
    val comment: String,
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    val product: Product,
)
