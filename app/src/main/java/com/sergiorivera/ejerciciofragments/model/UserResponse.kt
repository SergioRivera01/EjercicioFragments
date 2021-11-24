package com.sergiorivera.ejerciciofragments.model

data class UserResponse(
    val info: Info,
    val results: List<User>
)