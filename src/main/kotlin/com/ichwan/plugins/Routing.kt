package com.ichwan.plugins

import com.ichwan.entity.Product
import com.ichwan.service.ProductService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {

        val productService = ProductService()

        get("/product"){
            call.respond(
                HttpStatusCode.OK,
                //product.toList()
            )
        }

        get("/product/{id}") {
            val id = call.parameters["id"]

            if (id == null){
                call.respond(
                    HttpStatusCode.BadRequest,
                    "id parameter should be a number"
                )
                return@get
            }
        }

        post("/product") {

            val product = call.receive<Product>()

            val data = productService.addProduct(product)

            call.respond(data)
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
                call.respond(HttpStatusCode.NotFound,
                    "product not found")
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
                call.respond(HttpStatusCode.NotFound,
                    "product not found")
            }
        }

        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
}
