package com.example.server.service

import com.example.server.controller.dto.UserCreateRequestDto
import com.example.server.controller.dto.UserInfoResponseDto
import com.example.server.entity.User
import com.example.server.entity.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {

    @Transactional
    fun createUser(dto: UserCreateRequestDto): UserInfoResponseDto {
        val user = userRepository.save(User(email = dto.email, nickname = dto.nickname))
        return UserInfoResponseDto.from(user)
    }

    @Transactional(readOnly = true)
    fun findUser(userId: Int): UserInfoResponseDto {
        val user = userRepository.findById(userId).orElseThrow { RuntimeException("User not found! (id: $userId)") }
        return UserInfoResponseDto.from(user)
    }
}