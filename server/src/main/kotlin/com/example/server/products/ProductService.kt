package com.example.server.products

import com.example.server.DuplicateException

interface ProductService {

    fun getAll() : List<ProductDTO>

    fun getProduct(ean: String) : ProductDTO?

    fun getByIdProduct(ean:String):Product

    @Throws(DuplicateException::class)
    fun addProduct(productDTO: ProductDTO): ProductDTO
}