package com.somnwal.study.reservation.exception

import com.somnwal.study.reservation.dto.common.Response
import org.aspectj.weaver.ast.Not
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleUnknownException(e: Exception): ResponseEntity<Response> {
        return ResponseEntity(
            Response(
                status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
                message = e.message.toString(),
            ),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(e: NotFoundException): ResponseEntity<Response> {
        return ResponseEntity(
            Response(
                status = HttpStatus.NOT_FOUND.value(),
                message = e.message.toString(),
            ),
            HttpStatus.NOT_FOUND
        )
    }

    @ExceptionHandler(NameValueRequiredException::class)
    fun handleNameValueRequiredException(e: NameValueRequiredException): ResponseEntity<Response> {
        return ResponseEntity(
            Response(
                status = HttpStatus.BAD_REQUEST.value(),
                message = e.message.toString(),
            ),
            HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(InvalidCredentialException::class)
    fun handleInvalidCredentialException(e: InvalidCredentialException): ResponseEntity<Response> {
        return ResponseEntity(
            Response(
                status = HttpStatus.BAD_REQUEST.value(),
                message = e.message.toString(),
            ),
            HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(InvalidReservationStatusException::class)
    fun handleInvalidReservationStatusException(e: InvalidReservationStatusException): ResponseEntity<Response> {
        return ResponseEntity(
            Response(
                status = HttpStatus.BAD_REQUEST.value(),
                message = e.message.toString(),
            ),
            HttpStatus.BAD_REQUEST
        )
    }
}