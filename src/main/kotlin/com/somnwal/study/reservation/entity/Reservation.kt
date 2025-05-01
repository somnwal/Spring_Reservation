package com.somnwal.study.reservation.entity

import com.somnwal.study.reservation.enums.ReservationStatus
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "reservation")
data class Reservation (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    // 하나의 사용자가 여러개의 예약을 할 수 있으므로, ManyToOne 사용
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,

    // 하나의 방이 여러개의 예약을 받을 수 있으므로, ManyToOne 사용
    @ManyToOne
    @JoinColumn(name = "user_id")
    val room: Room,

    val checkInDate: LocalDateTime,
    val checkOutDate: LocalDateTime,

    val totalPrice: Double,
    val reservationRef: String,
    val createdAt: LocalDateTime,

    @Enumerated(EnumType.STRING)
    val reservationStatus: ReservationStatus,
)