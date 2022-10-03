package com.example.kotlinplayground.join.application.port.service

import com.example.kotlinplayground.join.adapter.dto.LoginDto
import com.example.kotlinplayground.join.adapter.out.MemberRepository
import com.example.kotlinplayground.join.application.port.LoginUseCase
import com.example.kotlinplayground.join.application.port.out.LoginPort
import com.example.kotlinplayground.join.domain.Member
import org.springframework.stereotype.Service

@Service
class LoginService(
    private val loginPort : LoginPort
) : LoginUseCase{

    override fun login(dto: LoginDto) : Member {
        return loginPort.validLogin(dto)
    }
}