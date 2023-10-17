package com.example.server.profiles

data class ProfileDTO(val email : String, val name: String, val role: String, val phone: String) {
    fun fromDTO() : Profile {
        return Profile(email, name,role,phone)
    }
}
    fun Profile.toDTO() : ProfileDTO {
        return ProfileDTO(email,name,role,phone)
    }

