package com.ichwan.database

import org.ktorm.database.Database
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
}