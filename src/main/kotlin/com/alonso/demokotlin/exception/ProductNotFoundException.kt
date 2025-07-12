package com.alonso.demokotlin.exception

import java.math.BigInteger

class ProductNotFoundException(id: BigInteger) : RuntimeException("Product with id $id not found")