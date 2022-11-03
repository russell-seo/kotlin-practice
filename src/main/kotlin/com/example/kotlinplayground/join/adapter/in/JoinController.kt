package com.example.kotlinplayground.join.adapter.`in`

import com.example.kotlinplayground.ApiResponse
import com.example.kotlinplayground.join.adapter.dto.JoinDto
import com.example.kotlinplayground.join.adapter.dto.JoinResponseDto
import com.example.kotlinplayground.join.adapter.dto.LoginDto
import com.example.kotlinplayground.join.adapter.dto.LoginResponseDto
import com.example.kotlinplayground.join.application.port.JoinUseCase
import com.example.kotlinplayground.join.application.port.LoginUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class JoinController (
    private val joinUseCase : JoinUseCase,
    private  val loginUseCase: LoginUseCase
)
{



    @PostMapping("/api/v1/join")
    fun join(@RequestBody dto : JoinDto) : ApiResponse<JoinResponseDto> {
       var userId = joinUseCase.joinMember(dto)
        return ApiResponse.ok(JoinResponseDto(userId, "성공적으로 가입이 완료 되었습니다."))
    }

    @PostMapping("/api/v1/login")
    fun login(@RequestBody dto : LoginDto) : ApiResponse<LoginResponseDto>{
        return ApiResponse.ok(loginUseCase.login(dto))
    }

    @GetMapping("/api/v1/exception")
    fun error() {
        throw Exception("예외처리")
    }

}