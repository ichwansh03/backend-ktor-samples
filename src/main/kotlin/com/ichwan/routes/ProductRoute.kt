package com.ichwan.routes

import com.ichwan.repository.ProductRepository
import com.ichwan.service.DbProductService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.productRoute() {

    val productService: ProductRepository = DbProductService()

    get("/product"){
        call.respond(HttpStatusCode.OK, productService.getAllProduct())
    }
}