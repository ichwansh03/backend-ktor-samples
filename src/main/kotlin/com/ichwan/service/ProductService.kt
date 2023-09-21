package com.ichwan.service

import com.ichwan.entity.Product
import com.ichwan.repository.ProductRepository

class ProductService : ProductRepository {

    private val products = mutableListOf<Product>()

    override fun getAllProduct(): List<Product> {
        return products
    }

    override fun getProduct(id: Int): Product? {
        return products.firstOrNull { it.id == id }
    }

    override fun addProduct(product: Product): Product {
        val data = Product(
            id = products.size + 1,
            name = product.name,
            category = product.category,
            price = product.price,
            stock = product.stock
        )

        products.add(data)

        return data
    }

    override fun updateProduct(id: Int, product: Product): Boolean {
        val data = products.firstOrNull { it.id == id } ?: return false

        data.name = product.name
        data.category = product.category
        data.price = product.price
        data.stock = product.stock

        return true
    }

    override fun deleteProduct(id: Int): Boolean {
        return products.removeIf { it.id == id }
    }
}