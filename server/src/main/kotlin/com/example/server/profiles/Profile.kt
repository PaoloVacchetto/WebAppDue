package com.example.server.profiles

import jakarta.persistence.*

enum class Roles {
    CUSTOMER, ADMIN, MANAGER, TECHNICIAN
}


@Entity
@Table(name = "profiles")
class Profile(
    @Id var email:String,
    var name: String,
    @Enumerated(value = EnumType.STRING)
    var role: Roles = Roles.CUSTOMER,
    var phone: String,
)