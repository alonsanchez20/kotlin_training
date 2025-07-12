package com.alonso.demokotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class DemoKotlinApplication

fun main(args: Array<String>) {
    runApplication<DemoKotlinApplication>(*args)
}
