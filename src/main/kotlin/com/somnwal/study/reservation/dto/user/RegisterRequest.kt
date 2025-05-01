package com.somnwal.study.reservation.dto.user

import com.somnwal.study.reservation.enums.UserRole
import jakarta.validation.constraints.NotBlank

data class RegisterRequest (

    @NotBlank(message = "이름을 입력해주세요.")
    var name: String,

    @NotBlank(message = "비밀번호를 입력해주세요.")
    var password: String,

    @NotBlank(message = "휴대폰번호를 입력해주세요.")
    var phoneNumber: String,

    var userRole: UserRole,
)