package com.alonso.demokotlin.security.service

import com.alonso.demokotlin.security.entity.User
import com.alonso.demokotlin.security.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder = BCryptPasswordEncoder(),
) {
    fun findByUsername(username: String): User? = userRepository.findByUsername(username)

    fun save(user: User): User {
        val hashedPassword = passwordEncoder.encode(user.password)
        val userToSave = user.copy(password = hashedPassword)
        return userRepository.save(userToSave)
    }
}
