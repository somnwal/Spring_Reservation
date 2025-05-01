package com.somnwal.study.reservation.dto.reservation

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.somnwal.study.reservation.dto.room.RoomDto
import com.somnwal.study.reservation.dto.user.UserDto
import com.somnwal.study.reservation.enums.PaymentStatus
import com.somnwal.study.reservation.enums.ReservationStatus
import lombok.Builder
import java.time.LocalDateTime

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ReservationDto (
    val id: Long,
    val user: UserDto,
    val room: RoomDto,
    val roomId: Long,

    val paymentStatus: PaymentStatus,
    val reservationStatus: ReservationStatus,

    val checkInDate: LocalDateTime,
    val checkOutDate: LocalDateTime,

    val totalPrice: Double,
    val reservationRef: String,
    val createdAt: LocalDateTime,
)