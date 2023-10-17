package com.example.server.products


data class ProductDTO (val productId: String, val name : String, val brand: String)

fun Product.toDTO() : ProductDTO {
    return ProductDTO(productId,name,brand)
}