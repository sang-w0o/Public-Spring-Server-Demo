package com.example.server.controller

import com.example.server.controller.dto.UserCreateRequestDto
import com.example.server.controller.dto.UserInfoResponseDto
import com.example.server.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserApiController(
    private val userService: UserService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody requestDto: UserCreateRequestDto): UserInfoResponseDto {
        return userService.createUser(requestDto)
    }

    @GetMapping("/{userId}")
    fun findUser(@PathVariable userId: Int): UserInfoResponseDto {
        return userService.findUser(userId)
    }
}