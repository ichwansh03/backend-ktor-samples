package com.ichwan.repository

import com.ichwan.entity.Product

interface ProductRepository {

    fun getAllProduct() : List<Product>

    fun getProduct(id: Int) : Product?

    fun addProduct(product: Product) : Product

    fun updateProduct(id: Int, product: Product) : Boolean

    fun deleteProduct(id: Int) : Boolean
}