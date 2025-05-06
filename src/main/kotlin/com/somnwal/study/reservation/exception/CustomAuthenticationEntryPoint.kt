package com.somnwal.study.reservation.exception

import com.fasterxml.jackson.databind.ObjectMapper
import com.somnwal.study.reservation.dto.common.Response
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component

@Component
class CustomAuthenticationEntryPoint: AuthenticationEntryPoint {

    private val objectMapper = ObjectMapper()

    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authException: AuthenticationException?
    ) {
        val errorResponse = Response(
            status = HttpStatus.UNAUTHORIZED.value(),
            message = authException?.message ?: "",
        )

        response?.contentType = MediaType.APPLICATION_JSON_VALUE
        response?.status = HttpStatus.UNAUTHORIZED.value()

        response?.writer?.write(objectMapper.writeValueAsString(errorResponse))
    }
}