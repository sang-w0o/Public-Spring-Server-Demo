package com.example.server.entity

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:Column(nullable = false, name = "user_id")
    val id: Int? = null,

    @field:Column(name = "email")
    val email: String,

    @field:Column(name = "nickname")
    val nickname: String
)