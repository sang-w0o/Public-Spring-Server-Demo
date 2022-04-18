package com.example.server.controller.dto

import com.example.server.entity.User

data class UserInfoResponseDto(
    val id: Int,
    val email: String,
    val nickname: String
) {
    companion object {
        fun from(user: User) = UserInfoResponseDto(user.id!!, user.email, user.nickname)
    }
}
