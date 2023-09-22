package com.ichwan.routes

import com.ichwan.entity.Product
import com.ichwan.repository.ProductRepository
import com.ichwan.service.DbProductService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.productRoute() {

    val productService: ProductRepository = DbProductService()

    get("/product") {
        call.respond(HttpStatusCode.OK, productService.getAllProduct())
    }

    get("/product/{id}") {
        val id = call.parameters["id"]?.toIntOrNull()

        if (id == null) {
            call.respond(
                HttpStatusCode.BadRequest,
                "id parameter should be a number"
            )
            return@get
        }

        val product = productService.getProduct(id)

        if (product == null){
            call.respond(
                HttpStatusCode.NotFound,
                "id not found"
            )
        } else {
            call.respond(product)
        }
    }

    post("/product") {

        val product = call.receive<Product>()

        call.respond(HttpStatusCode.OK, productService.addProduct(product))
    }

    put("/product/{id}") {
        val product = call.receive<Product>()
        val productId = call.parameters["id"]?.toIntOrNull()

        if (productId == null) {
            call.respond(HttpStatusCode.BadRequest, "id should be a number")
            return@put
        }

        val updated = productService.updateProduct(productId, product)
        if (updated) {
            call.respond(HttpStatusCode.OK)
        } else {
            call.respond(
                HttpStatusCode.NotFound,
                "product not found"
            )
        }
    }

    delete("/product/{id}") {
        val productId = call.parameters["id"]?.toIntOrNull()

        if (productId == null) {
            call.respond(HttpStatusCode.BadRequest, "id should be a number")
            return@delete
        }

        val deleted = productService.deleteProduct(productId)
        if (deleted) {
            call.respond(HttpStatusCode.OK)
        } else {
            call.respond(
                HttpStatusCode.NotFound,
                "product not found"
            )
        }
    }

}