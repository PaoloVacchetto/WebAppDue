package com.example.server.products

import com.example.server.NotFoundException
import org.springframework.stereotype.Service
import org.springframework.data.repository.findByIdOrNull



@Service
class ProductServiceImpl (private val productRepository: ProductRepository) : ProductService {

    override fun getAll(): List<ProductDTO> {
        return productRepository.findAll().map{it.toDTO()}
    }

    override fun getProduct(ean: String): ProductDTO {
        return productRepository.findByIdOrNull(ean)?.toDTO() ?: throw NotFoundException("Product not found")

    }

    override fun getByIdProduct(ean: String): Product {
        return productRepository.findByIdOrNull(ean) ?: throw NotFoundException ("Product not found")
    }

}