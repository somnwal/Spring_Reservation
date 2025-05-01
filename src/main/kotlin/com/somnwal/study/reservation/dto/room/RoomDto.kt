package com.somnwal.study.reservation.dto.room

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.somnwal.study.reservation.enums.RoomType
import lombok.Builder

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class RoomDto (
    val id: Long,
    val roomNumber: Int,

    val type: RoomType,

    val pricePerNight: Double,

    val capacity: Int,

    val description: String,
    val imageUrl: String,
)