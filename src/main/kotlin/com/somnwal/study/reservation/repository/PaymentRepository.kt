package com.somnwal.study.reservation.repository

import com.somnwal.study.reservation.entity.Payment
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentRepository: JpaRepository<Payment, Long> {


}