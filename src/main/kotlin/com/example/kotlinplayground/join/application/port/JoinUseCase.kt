package com.example.kotlinplayground.join.application.port

import com.example.kotlinplayground.join.adapter.dto.JoinDto
import org.springframework.stereotype.Component

@Component
interface JoinUseCase {

    fun joinMember(dto : JoinDto)
}