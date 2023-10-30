package com.example.server.profiles

import com.example.server.NotFoundException
import kotlin.jvm.Throws

interface ProfileService  {

    @Throws(NotFoundException::class)
    fun getProfileByEmail(email: String) : ProfileDTO?

    @Throws(NotFoundException::class)
    fun getProfileByEmailP(email: String) : Profile

    @Throws(NotFoundException::class)
    fun addProfile(profileDTO: ProfileDTO): ProfileDTO

    @Throws(NotFoundException::class)
    fun editProfile(profileDTO: ProfileDTO, email: String) : ProfileDTO
}