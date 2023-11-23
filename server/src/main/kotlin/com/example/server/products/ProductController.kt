package com.example.server.products


import com.example.server.NotValidException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ProductController(private val productService: ProductService) {

    @GetMapping("/products")
    fun getAll() :List<ProductDTO> {
        return productService.getAll()
    }

    @GetMapping("/products/{ean}")
    fun getProduct(@PathVariable ean:String) : ProductDTO? {
        return productService.getProduct(ean)
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    fun addProduct(@RequestBody productDTO: ProductDTO?): ProductDTO {
        if (productDTO == null) throw NotValidException("Product was malformed")
        return productService.addProduct(productDTO)
    }
}