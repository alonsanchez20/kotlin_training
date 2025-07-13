package com.alonso.demokotlin.security.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

@Component
class JwtUtil {
    @Value("\${application.security.jwt.secret}")
    lateinit var secret: String

    fun generateToken(username: String): String {
        println("Secret: $secret")

        val key = Keys.hmacShaKeyFor(secret.toByteArray())
        val expirationDate =
            Date.from(
                LocalDateTime
                    .now()
                    .plusMinutes(20)
                    .atZone(ZoneId.systemDefault())
                    .toInstant(),
            )
        return Jwts
            .builder()
            .setSubject(username)
            .setExpiration(expirationDate)
            .signWith(key, SignatureAlgorithm.HS512)
            .compact()
    }

    fun validateToken(token: String): Boolean =
        try {
            println("validateToken: $token")
            val key = Keys.hmacShaKeyFor(secret.toByteArray())
            val claims =
                Jwts
                    .parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
            !claims.body.expiration.before(Date())
        } catch (e: Exception) {
            println("invalid token")
            println(e.message)
            false
        }
}
