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
    val message: String,

    // Login
    val token: String,
    val userRole: UserRole,
    val isActive: Boolean,
    val expirationTime: String,

    // Data Output
    val user: UserDto,
    val users: List<UserDto>,

    // Reservation
    val reservation: ReservationDto,
    val reservations: List<ReservationDto>,

    // Room
    val room: RoomDto,
    val rooms: List<RoomDto>,

    // Payment
    val payment: PaymentDto,
    val payments: List<PaymentDto>,

    // Notification
    val notification: NotificationDto,
    val notifications: List<NotificationDto>,

    val timestamp: LocalDateTime = LocalDateTime.now(),
)