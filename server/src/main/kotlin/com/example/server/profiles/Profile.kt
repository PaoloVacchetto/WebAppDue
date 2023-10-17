package com.example.server.profiles

import jakarta.persistence.*


@Entity
@Table(name = "profile")
class Profile(
    @Id var email:String,
    var name: String,
    var role: String,
    var phone: String,
)