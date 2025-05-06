package com.somnwal.study.reservation.exception

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.somnwal.study.reservation.dto.common.Response
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component

@Component
class CustomAccessDeniedHandler: AccessDeniedHandler {

    private val objectMapper = jacksonObjectMapper()

    override fun handle(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        accessDeniedException: AccessDeniedException?
    ) {
        val errorResponse = Response(
            status = HttpStatus.FORBIDDEN.value(),
            message = accessDeniedException?.message ?: "",
        )

        response?.contentType = MediaType.APPLICATION_JSON_VALUE
        response?.status = HttpStatus.FORBIDDEN.value()

        response?.writer?.write(objectMapper.writeValueAsString(errorResponse))
    }
}