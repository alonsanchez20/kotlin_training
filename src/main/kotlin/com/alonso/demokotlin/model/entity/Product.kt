package com.alonso.demokotlin.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSeqGen")
    @SequenceGenerator(name = "productSeqGen", sequenceName = "product_id_seq", allocationSize = 1)
    val id: Long?,
    @Column(unique = true, nullable = false)
    val name: String,
    @Column(nullable = false)
    val price: Double,
    @OneToMany(mappedBy = "product", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonIgnore
    val reviews: List<Review> = mutableListOf(),
)
