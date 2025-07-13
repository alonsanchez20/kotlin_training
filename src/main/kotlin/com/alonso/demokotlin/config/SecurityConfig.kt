package com.alonso.demokotlin.config

import com.alonso.demokotlin.security.jwt.JwtFilter
import com.alonso.demokotlin.security.jwt.JwtUtil
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtUtil: JwtUtil,
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .authorizeHttpRequests {
                it.requestMatchers("/api/v1/auth/login", "/api/v1/auth/register").permitAll()
                it.anyRequest().authenticated()
            }.addFilterBefore(
                JwtFilter(jwtUtil),
                org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter::class.java,
            )
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}
