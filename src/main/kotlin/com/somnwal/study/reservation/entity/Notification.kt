package com.somnwal.study.reservation.entity

import com.somnwal.study.reservation.enums.NotificationType
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import lombok.Builder
import java.time.Instant
import java.time.LocalDateTime

@Entity
@Table(name = "notification")
@Builder
data class Notification (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val subject: String,

    @NotBlank(message = "수신자는 필수입력 항목입니다.")
    val recipient: String,

    val body: String,

    val reservationRef: String,

    @Enumerated(EnumType.STRING)
    val notificationType: NotificationType,

    val createdAt: LocalDateTime = LocalDateTime.now(),

    )