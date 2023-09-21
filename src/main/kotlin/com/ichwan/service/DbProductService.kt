package com.ichwan.service

import com.ichwan.database.DatabaseManager
import com.ichwan.entity.Product
import com.ichwan.repository.ProductRepository

class DbProductService : ProductRepository {

    private val database = DatabaseManager()

    override fun getAllProduct(): List<Product> {
        return database.getAllProducts().map {
            Product(
                it.id,
                it.name,
                it.category,
                it.price,
                it.stock
            )
        }
    }

    override fun getProduct(id: Int): Product? {
        TODO("Not yet implemented")
    }

    override fun addProduct(product: Product): Product {
        TODO("Not yet implemented")
    }

    override fun updateProduct(id: Int, product: Product): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteProduct(id: Int): Boolean {
        TODO("Not yet implemented")
    }
}