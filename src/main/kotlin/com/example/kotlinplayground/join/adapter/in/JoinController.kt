package com.example.kotlinplayground.join.adapter.`in`

import com.example.kotlinplayground.ApiResponse
import com.example.kotlinplayground.join.adapter.dto.JoinDto
import com.example.kotlinplayground.join.application.port.JoinUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class JoinController (private val joinUseCase : JoinUseCase){



    @PostMapping("/join")
    fun join(@RequestBody dto : JoinDto) : ApiResponse<Any> {
        return ApiResponse.ok()
    }

}