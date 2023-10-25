package com.example.server.profiles

interface ProfileService  {

    fun getProfileByEmail(email: String) : ProfileDTO?

    fun addProfile(profileDTO: ProfileDTO): ProfileDTO

    fun editProfile(profileDTO: ProfileDTO, email: String) : ProfileDTO
}