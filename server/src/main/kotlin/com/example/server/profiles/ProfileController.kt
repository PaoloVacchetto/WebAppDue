package com.example.server.profiles

import com.example.server.NotFoundException
import com.example.server.NotValidException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ProfileController (private val profileService : ProfileService) {

    @GetMapping("/profiles/{email}")
    fun getProfileByEmail(@PathVariable email:String) : ProfileDTO ? {
        return profileService.getProfileByEmail(email)
    }

    @PostMapping("/profiles")
    @ResponseStatus(HttpStatus.CREATED)
    fun postProfile(@RequestBody profileDTO: ProfileDTO?) : ProfileDTO {
        if (profileDTO == null) throw NotValidException("Profile was malformed")
        return profileService.addProfile(profileDTO)
    }

    @PutMapping("/profiles/{email}")
    @ResponseStatus(HttpStatus.CREATED)
    fun editProfile(@RequestBody profileDTO: ProfileDTO?, @PathVariable email:String?) : ProfileDTO {
        if (profileDTO == null) throw NotFoundException("Profile not found")
        if (profileDTO.email != email) throw NotValidException("Profile id and profile path do not match")

        return profileService.editProfile(profileDTO,email)
    }
}