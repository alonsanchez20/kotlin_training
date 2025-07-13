@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.alonso.demokotlin.security.entity

import jakarta.persistence.*

@Entity
@Table(name = "\"user\"")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(unique = true, nullable = false)
    val username: String,
    @Column(nullable = false)
    val password: String,
    val role: String = "USER",
)
