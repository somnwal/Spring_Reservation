package com.somnwal.study.reservation.entity

import com.somnwal.study.reservation.enums.UserRole
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @NotBlank(message = "이메일을 입력해주세요.")
    @Column(unique = true)
    var email: String,

    @NotBlank(message = "비밀번호를 입력해주세요.")
    var password: String,
    var firstName: String,
    var lastName: String,

    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Column(name="phone_number")
    var phoneNumber: String,

    @Enumerated(EnumType.STRING)
    var userRole: UserRole,

    var isActive: Boolean,
    val createdAt: LocalDateTime = LocalDateTime.now(),
)