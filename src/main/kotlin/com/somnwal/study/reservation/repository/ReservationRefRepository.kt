package com.somnwal.study.reservation.repository

import com.somnwal.study.reservation.entity.ReservationRef
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ReservationRefRepository: JpaRepository<ReservationRef,Long> {

    fun findByRefNo(refNo: String): Optional<ReservationRef>
}