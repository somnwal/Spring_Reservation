package com.somnwal.study.reservation.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import jakarta.annotation.PostConstruct
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.nio.charset.StandardCharsets
import java.util.Base64
import java.util.Date
import java.util.function.Function
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

@Service
@Slf4j
class JwtUtils(
    @Value("secreteJwtString")
    var secretJwtKey: String,
) {

    companion object {
        // JWT 토큰은 6개월 뒤 만료
        const val EXPIRATION_TIME: Long = 100L * 60L * 60L * 24L * 30L * 6L
    }

    private lateinit var key: SecretKey

    @PostConstruct
    private fun init() {
        val keyBytes = secretJwtKey.toByteArray(StandardCharsets.UTF_8)
        this.key = SecretKeySpec(keyBytes, "HmacSHA256")
    }

    fun generateToken(email: String): String {
        return Jwts.builder()
            .subject(email)
            .issuedAt(Date(System.currentTimeMillis()))
            .expiration(Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(key)
            .compact()
    }


    fun getUsernameFromToken(token: String): String? {
        return extractClaims(token, Claims::getSubject)
    }

    private fun <T> extractClaims(token: String, claimsFunction: (Claims) -> T): T {
        return claimsFunction(
            Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .payload
        )
    }

    fun isTokenValid(token: String, userDetails: UserDetails): Boolean {
        val username = getUsernameFromToken(token)

        return (username == userDetails.username && !isTokenExpired(token))
    }

    fun isTokenExpired(token: String): Boolean {
        return extractClaims(token, Claims::getExpiration).before(Date())
    }
}