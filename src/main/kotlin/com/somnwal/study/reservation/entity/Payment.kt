package com.somnwal.study.reservation.entity

import com.somnwal.study.reservation.enums.PaymentMethod
import com.somnwal.study.reservation.enums.PaymentStatus
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import lombok.Builder
import java.time.LocalDateTime

@Entity
@Table(name = "payment")
@Builder
data class Payment (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val transactionId: String,

    val amount: Double,

    @Enumerated(EnumType.STRING)
    val paymentMethod: PaymentMethod,

    val paymentDate: LocalDateTime,

    @Enumerated(EnumType.STRING)
    val paymentStatus: PaymentStatus,

    val reservationRef: String,
    val failureReason: String,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,
)