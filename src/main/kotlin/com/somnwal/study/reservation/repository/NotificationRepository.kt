package com.somnwal.study.reservation.repository

import com.somnwal.study.reservation.entity.Notification
import org.springframework.data.jpa.repository.JpaRepository

interface NotificationRepository: JpaRepository<Notification, Long> {
}