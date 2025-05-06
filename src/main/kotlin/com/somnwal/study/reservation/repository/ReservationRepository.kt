package com.somnwal.study.reservation.repository

import com.somnwal.study.reservation.entity.Reservation
import com.somnwal.study.reservation.entity.ReservationRef
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDate
import java.util.Optional


interface ReservationRepository: JpaRepository<ReservationRef, Long> {

    fun findByUserId(userId: Long?): MutableList<Reservation?>? // Fetch all bookings for a specific user

    fun findByBookingReference(bookingReference: String?): Optional<Reservation?>?

    @Query(
        """
               SELECT CASE WHEN COUNT(b) = 0 THEN true ELSE false END
                FROM Reservation b
                WHERE b.room.id = :roomId
                  AND :checkInDate <= b.checkOutDate
                  AND :checkOutDate >= b.checkInDate
                  AND b.reservationStatus IN ('BOOKED', 'CHECKED_IN')
            
            """
    )
    fun isRoomAvailable(
        @Param("roomId") roomId: Long?,
        @Param("checkInDate") checkInDate: LocalDate?,
        @Param("checkOutDate") checkOutDate: LocalDate?
    ): Boolean
}