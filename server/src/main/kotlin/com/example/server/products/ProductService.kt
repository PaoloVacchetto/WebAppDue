package com.example.server.products

interface ProductService {

    fun getAll() : List<ProductDTO>

    fun getProduct(ean: String) : ProductDTO?

    fun getByIdProduct(ean:String):Product
}