package com.somnwal.study.reservation.security

import com.somnwal.study.reservation.entity.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthUser(val user: User): UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority?>? {
        return listOf(SimpleGrantedAuthority(user.userRole.name))
    }

    override fun getPassword(): String? {
        return user.password
    }

    override fun getUsername(): String? {
        return user.email
    }
}