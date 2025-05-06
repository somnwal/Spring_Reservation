package com.somnwal.study.reservation.repository

import com.somnwal.study.reservation.entity.Room
import com.somnwal.study.reservation.enums.RoomType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDate


interface RoomRepository: JpaRepository<Room, Long> {

    @Query(
        """
            SELECT r FROM Room r
            WHERE
                r.id NOT IN (
                    SELECT b.room.id
                    FROM Reservation b
                    WHERE :checkInDate <= b.checkOutDate
                    AND :checkOutDate >= b.checkInDate
                    AND b.reservationStatus IN ('BOOKED', 'CHECKED_IN')
                )
                AND (:roomType IS NULL OR r.roomType = :roomType)
            
            """
    )
    fun findAvailableRooms(
        @Param("checkInDate") checkInDate: LocalDate?,
        @Param("checkOutDate") checkOutDate: LocalDate?,
        @Param("roomType") roomType: RoomType?
    ): MutableList<Room?>?

    @Query(
        """
                SELECT r FROM Room r
                WHERE CAST(r.roomNumber AS string) LIKE %:searchParam%
                   OR LOWER(r.roomType) LIKE LOWER(:searchParam)
                   OR CAST(r.pricePerNight AS string) LIKE %:searchParam%
                   OR CAST(r.capacity AS string) LIKE %:searchParam%
                   OR LOWER(r.description) LIKE LOWER(CONCAT('%', :searchParam, '%'))
            
            """
    )
    fun searchRooms(@Param("searchParam") searchParam: String?): MutableList<Room?>?
}