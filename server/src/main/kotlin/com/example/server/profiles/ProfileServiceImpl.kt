package com.example.server.profiles

import io.micrometer.observation.annotation.Observed
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
@Transactional
@Observed
class ProfileServiceImpl(private val profileRepository: ProfileRepository) : ProfileService {

    override fun getProfileByEmail(email: String): ProfileDTO? {
        return profileRepository.findByIdOrNull(email)?.toDTO()
    }
    override fun addProfile(profileDTO: ProfileDTO): ProfileDTO {
        if (profileRepository.findByIdOrNull(profileDTO.email) != null) return ProfileDTO("","", "","")
        return profileRepository.save(
            Profile(
                email = profileDTO.email,
                name = profileDTO.name,
                role = profileDTO.role,
                phone = profileDTO.phone
            )
        ).toDTO()
    }

    override fun putProfile(profileDTO: ProfileDTO, email : String): ProfileDTO {
        if (profileRepository.findByIdOrNull(email) != null) return ProfileDTO("","", "","")
        return profileRepository.save(
            Profile(
                email = profileDTO.email,
                name = profileDTO.name,
                role = profileDTO.role,
                phone = profileDTO.phone
            )
        ).toDTO()
    }
}