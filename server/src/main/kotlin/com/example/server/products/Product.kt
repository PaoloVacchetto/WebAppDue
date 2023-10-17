package com.example.server.products

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name="products")
class Product {
    @Id
    var productId : String = ""
    var name : String = ""
    var brand : String = ""
}