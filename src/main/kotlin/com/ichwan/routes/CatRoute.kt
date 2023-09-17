package com.ichwan.routes

import com.ichwan.data.Cat
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val BASE_URL = "http://192.168.43.8:8100/"
private val cats = listOf(
    Cat("Persia", "Kucing persia flatnose", "$BASE_URL/cats/persia.jpg"),
    Cat("Himalaya", "Kucing himalaya ekor coklat", "$BASE_URL/cats/himalaya.jpg"),
    Cat("British", "Kucing british bulu pendek", "$BASE_URL/cats/british.jpg"),
    Cat("Anggora", "Kucing anggora bulu putih", "$BASE_URL/cats/anggora.jpg"),
    Cat("Bengal", "Kucing loreng bengal", "$BASE_URL/cats/bengal.jpg"),
)

fun Route.getCat(){

    get("cat"){
        call.respond(
            HttpStatusCode.OK,
            cats.toList()
        )
    }
}