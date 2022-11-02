package com.example.kotlinplayground.join.application.port.out

import com.example.kotlinplayground.join.adapter.dto.LoginDto
import com.example.kotlinplayground.join.domain.Member

interface LoginPort {

    fun validLogin(dto: LoginDto) : Member
}