package com.alonso.demokotlin.security.controller

import com.alonso.demokotlin.security.entity.User
import com.alonso.demokotlin.security.jwt.JwtUtil
import com.alonso.demokotlin.security.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    private val jwtUtil: JwtUtil,
    private val userService: UserService,
    private val passwordEncoder: PasswordEncoder,
) {
    @PostMapping("/login")
    fun login(
        @RequestBody loginRequest: LoginRequest,
    ): ResponseEntity<Map<String, String>> {
        val user = userService.findByUsername(loginRequest.username)
        if (user != null && passwordEncoder.matches(loginRequest.password, user.password)) {
            val token = jwtUtil.generateToken(user.username)
            return ResponseEntity.ok(mapOf("token" to token))
        }
        return ResponseEntity.status(401).build()
    }

    @PostMapping("/register")
    fun register(
        @RequestBody registerRequest: RegisterRequest,
    ): ResponseEntity<Map<String, String>> {
        val user =
            User(
                username = registerRequest.username,
                password = registerRequest.password,
                role = registerRequest.role ?: "USER",
            )
        userService.save(user)
        return ResponseEntity.ok(mapOf("message" to "Usuario creado correctamente"))
    }
}

data class LoginRequest(
    val username: String,
    val password: String,
)

data class RegisterRequest(
    val username: String,
    val password: String,
    val role: String? = null,
)
