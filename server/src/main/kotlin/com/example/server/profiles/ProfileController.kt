package com.example.server.profiles

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ProfileController (private val profileService : ProfileService) {

    @GetMapping("/profiles/{email}")
    fun getProfileByEmail(@PathVariable email:String) : ProfileDTO ? {
        return profileService.getProfileByEmail(email)
    }

    @PostMapping("/profiles")
    fun postProfile(@RequestBody profileDTO: ProfileDTO?) : ProfileDTO {
        if (profileDTO == null) return ProfileDTO("","","","")
        return profileService.addProfile(profileDTO)
    }

    @PutMapping("/profiles/{email}")
    fun editProfile(@RequestBody profileDTO: ProfileDTO?, @PathVariable email:String?) : ProfileDTO {
        if (profileDTO == null) return ProfileDTO("","","","")
        if (email == null) return ProfileDTO("","","","")
        return profileService.editProfile(profileDTO,email)
    }
}