package com.ichwan.database

import org.ktorm.entity.Entity
import org.ktorm.schema.*

object TableEntities: Table<DBProductEntity>("product") {

    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
    val category = varchar("category").bindTo { it.category }
    val price = int("price").bindTo { it.price }
    val stock = int("stock").bindTo { it.stock }
}

interface DBProductEntity : Entity<DBProductEntity>{
    companion object : Entity.Factory<DBProductEntity>()

    val id: Int
    val name: String
    val category: String
    val price: Int
    val stock: Int
}