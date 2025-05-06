package com.somnwal.study.reservation.security

import com.somnwal.study.reservation.exception.NotFoundException
import com.somnwal.study.reservation.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    val userRepository: UserRepository
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails? {
        val user = userRepository
            .findByEmail(username)
            .orElseThrow {
                NotFoundException("User $username not found")
            }

        return AuthUser(user)
    }
}