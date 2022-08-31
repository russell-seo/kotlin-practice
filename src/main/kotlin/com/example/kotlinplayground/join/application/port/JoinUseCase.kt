package com.example.kotlinplayground.join.application.port

import com.example.kotlinplayground.join.adapter.dto.JoinDto

interface JoinUseCase {

    fun joinMember(dto : JoinDto)
}