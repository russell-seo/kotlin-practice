package com.example.kotlinplayground.join.adapter.`in`

import com.example.kotlinplayground.ApiResponse
import com.example.kotlinplayground.LoginResponseDto
import com.example.kotlinplayground.join.adapter.dto.JoinDto
import com.example.kotlinplayground.join.adapter.dto.LoginDto
import com.example.kotlinplayground.join.application.port.JoinUseCase
import com.example.kotlinplayground.join.application.port.LoginUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class JoinController (
    private val joinUseCase : JoinUseCase,
    private  val loginUseCase: LoginUseCase
)
{



    @PostMapping("/api/v1/join")
    fun join(@RequestBody dto : JoinDto) : ApiResponse<LoginResponseDto> {
        val token = joinUseCase.joinMember(dto)
        return ApiResponse.ok(LoginResponseDto(token))
    }

    @PostMapping("/api/v1/login")
    fun login(@RequestBody dto : LoginDto) : ApiResponse<Any>{
        loginUseCase.login(dto)
        return ApiResponse.ok()
    }


}