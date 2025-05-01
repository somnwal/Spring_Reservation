package com.somnwal.study.reservation.dto.payment

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.somnwal.study.reservation.dto.reservation.ReservationDto
import com.somnwal.study.reservation.dto.user.UserDto
import com.somnwal.study.reservation.enums.PaymentMethod
import com.somnwal.study.reservation.enums.PaymentStatus
import lombok.Builder
import java.time.LocalDateTime

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PaymentDto (
    val id: Long,
    val reservation: ReservationDto,
    val user: UserDto,

    val transactionId: String,

    val amount: Double,

    val paymentMethod: PaymentMethod,
    val paymentDate: LocalDateTime,
    val status: PaymentStatus,

    val reservationRef: String,
    val failureReason: String,
    val approvalLink: String,
)