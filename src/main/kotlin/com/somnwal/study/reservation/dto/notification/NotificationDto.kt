package com.somnwal.study.reservation.dto.notification

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.somnwal.study.reservation.enums.NotificationType
import jakarta.validation.constraints.NotBlank
import lombok.Builder
import java.time.LocalDateTime

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class NotificationDto (
    val id: Long,

    val notificationType: NotificationType,

    @NotBlank(message = "주제는 필수입력 항목입니다.")
    val subject: String,

    @NotBlank(message = "수신자는 필수입력 항목입니다.")
    val recipient: String,

    val body: String,

    val reservationRef: String,
    val createdAt: LocalDateTime,
)