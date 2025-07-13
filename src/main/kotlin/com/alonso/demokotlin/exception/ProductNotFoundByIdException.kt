package com.alonso.demokotlin.exception

class ProductNotFoundByIdException(
    id: Long,
) : RuntimeException("Product with id $id not found")
