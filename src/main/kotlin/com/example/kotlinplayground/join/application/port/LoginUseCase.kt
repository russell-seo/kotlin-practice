package com.example.kotlinplayground.join.application.port

import com.example.kotlinplayground.join.adapter.dto.LoginResponseDto
import com.example.kotlinplayground.join.adapter.dto.LoginDto

interface LoginUseCase {

    fun login(dto : LoginDto) : LoginResponseDto
}