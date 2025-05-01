package com.somnwal.study.reservation.dto.user

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.somnwal.study.reservation.enums.UserRole
import lombok.Builder
import java.time.LocalDateTime

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class UserDto(
    val id: Long,

    var email: String,
    var password: String,

    var name: String,
    var phoneNumber: String,

    var userRole: UserRole,

    var isActive: Boolean,
    val createdAt: LocalDateTime,
)