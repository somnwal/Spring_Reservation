package com.somnwal.study.reservation.repository

import com.somnwal.study.reservation.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository: JpaRepository<User, Long> {

    fun findByEmail(email: String): Optional<User>
}