package com.alonso.demokotlin.controller

import com.alonso.demokotlin.exception.ProductNotFoundByIdException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundByIdException::class)
    fun handleProductNotFoundException(ex: ProductNotFoundByIdException): ResponseEntity<String> =
        ResponseEntity(ex.message, HttpStatus.NOT_FOUND)

}