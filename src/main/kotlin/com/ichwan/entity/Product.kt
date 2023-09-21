package com.ichwan.entity

import kotlinx.serialization.Serializable

@Serializable
data class Product (

    var id: Int,
    var name: String,
    var category: String,
    var price: Int,
    var stock: Int
)