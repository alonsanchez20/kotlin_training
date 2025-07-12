package com.alonso.demokotlin.exception

import java.math.BigInteger

class ProductNotFoundByIdException(id: BigInteger) : RuntimeException("Product with id $id not found")
