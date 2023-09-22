package com.ichwan.database

import com.ichwan.entity.Product
import org.ktorm.database.Database
import org.ktorm.dsl.delete
import org.ktorm.dsl.eq
import org.ktorm.dsl.insertAndGenerateKey
import org.ktorm.dsl.update
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList

class DatabaseManager {

    private val hostname = "localhost"
    private val dbname = "productdb"
    private val username = "root"
    private val password = ""

    private val ktormDb: Database

    init {
        val jdbcUrl = "jdbc:mysql://$hostname:3306/$dbname?user=$username&password=$password&useSSL=false"
        ktormDb = Database.connect(jdbcUrl)
    }

    fun getAllProducts(): List<DBProductEntity> {
        return ktormDb.sequenceOf(TableEntities).toList()
    }

    fun getProduct(id: Int) : DBProductEntity? {
        return ktormDb.sequenceOf(TableEntities).firstOrNull { it.id.eq(id) }
    }

    fun addProduct(product: Product) : Product {
        var productId = ktormDb.insertAndGenerateKey(TableEntities) {
            set(TableEntities.name, product.name)
            set(TableEntities.category, product.category)
            set(TableEntities.price, product.price)
            set(TableEntities.stock, product.stock)
        } as Int

        return Product(productId, product.name, product.category, product.price, product.stock)
    }

    fun updateProduct(id: Int, product: Product): Boolean {
        val update = ktormDb.update(TableEntities) {
            set(TableEntities.name, product.name)
            set(TableEntities.category, product.category)
            set(TableEntities.price, product.price)
            set(TableEntities.stock, product.stock)
            where { it.id.eq(id) }
        }

        return update > 0
    }

    fun deleteProduct(id: Int) : Boolean{
        val delete = ktormDb.delete(TableEntities) {
            it.id.eq(id)
        }

        return delete > 0
    }
}