package com.somnwal.study.reservation.entity

import com.somnwal.study.reservation.enums.RoomType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import lombok.Builder
import org.hibernate.id.factory.spi.GenerationTypeStrategy
import org.springframework.cglib.core.GeneratorStrategy
import org.springframework.context.annotation.Description

@Entity
@Table(name = "rooms")
@Builder
data class Room (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Min(value = 1, message = "방 갯수는 1 에서 10 사이의 숫자로 입력해주세요.")
    @Column(unique = true)
    val roomNumber: Int,

    @Enumerated(value = EnumType.STRING)
    @NotNull(message = "방 종류는 필수 사항입니다.")
    val roomType: RoomType,

    @DecimalMin(value = "1.0", message="가격은 1원 보다 커야합니다.")
    val pricePerNight: Double,

    @Min(value = 1, message = "인원은 최소 1 보다 커야합니다.")
    val capacity: Int,

    val description: String,
    val imageUrl: String,
)