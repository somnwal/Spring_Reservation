package com.somnwal.study.reservation.dto.user

import jakarta.validation.constraints.NotBlank

data class LoginRequest (
    @NotBlank(message = "이메일을 입력해주세요.")
    var email: String,
    @NotBlank(message = "비밀번호를 입력해주세요.")
    var password: String,
)