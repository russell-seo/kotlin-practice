package com.example.kotlinplayground.join.application.port.service

import com.example.kotlinplayground.join.adapter.dto.LoginResponseDto
import com.example.kotlinplayground.auth.service.JwtService
import com.example.kotlinplayground.join.adapter.dto.LoginDto
import com.example.kotlinplayground.join.application.port.LoginUseCase
import com.example.kotlinplayground.join.application.port.out.LoginPort
import org.springframework.stereotype.Service

@Service
class LoginService(
     val loginPort : LoginPort,
     val jwtService: JwtService
) : LoginUseCase{

    override fun login(dto: LoginDto) : LoginResponseDto {
        val validDoneMember = loginPort.validLogin(dto)

        val token = jwtService.generateToken(validDoneMember.email, validDoneMember.name)

        return LoginResponseDto(token, validDoneMember.id!!)
    }
}