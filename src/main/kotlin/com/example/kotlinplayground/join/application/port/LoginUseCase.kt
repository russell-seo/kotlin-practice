package com.example.kotlinplayground.join.application.port

import com.example.kotlinplayground.join.adapter.dto.LoginDto
import com.example.kotlinplayground.join.domain.Member

interface LoginUseCase {

    fun login(dto : LoginDto) : Member
}