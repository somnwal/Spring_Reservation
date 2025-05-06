package com.somnwal.study.reservation.dto.common

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.somnwal.study.reservation.dto.notification.NotificationDto
import com.somnwal.study.reservation.dto.payment.PaymentDto
import com.somnwal.study.reservation.dto.reservation.ReservationDto
import com.somnwal.study.reservation.dto.room.RoomDto
import com.somnwal.study.reservation.dto.user.UserDto
import com.somnwal.study.reservation.enums.UserRole
import lombok.Builder
import java.time.LocalDateTime

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Response (
    val status: Int,
    val message: String = "",

    // Login
    val token: String? = null,
    val userRole: UserRole? = null,
    val isActive: Boolean = false,
    val expirationTime: String? = null,

    // Data Output
    val user: UserDto? = null,
    val users: List<UserDto>? = null,

    // Reservation
    val reservation: ReservationDto? = null,
    val reservations: List<ReservationDto>? = null,

    // Room
    val room: RoomDto? = null,
    val rooms: List<RoomDto>? = null,

    // Payment
    val payment: PaymentDto? = null,
    val payments: List<PaymentDto>? = null,

    // Notification
    val notification: NotificationDto? = null,
    val notifications: List<NotificationDto>? = null,

    val timestamp: LocalDateTime = LocalDateTime.now(),
)