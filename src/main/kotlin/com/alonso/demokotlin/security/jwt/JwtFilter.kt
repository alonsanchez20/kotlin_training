package com.alonso.demokotlin.security.jwt

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class JwtFilter(
    private val jwtUtil: JwtUtil,
) : OncePerRequestFilter() {
    private val logger = LoggerFactory.getLogger(JwtFilter::class.java)

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        val header = request.getHeader("Authorization")
        val isLogin = request.requestURI.contains("/api/v1/auth/login")
        val isRegister = request.requestURI.contains("/api/v1/auth/register")

        logger.info("Request URI: ${request.requestURI}")
        logger.info("Authorization header: $header")

        if (header != null && header.startsWith("Bearer ")) {
            val token = header.substring(7)
            if (jwtUtil.validateToken(token)) {
                logger.info("Token válido")
                val authentication = UsernamePasswordAuthenticationToken("usuario", null, emptyList())
                SecurityContextHolder.getContext().authentication = authentication
                filterChain.doFilter(request, response)
                return
            } else {
                logger.warn("Token inválido o expirado")
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido o expirado")
                return
            }
        } else if (!isLogin && !isRegister) {
            logger.warn("Falta el token")
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Falta el token")
            return
        }
        filterChain.doFilter(request, response)
    }
}
