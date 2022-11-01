package com.example.kotlinplayground.join.application.port

import com.example.kotlinplayground.join.adapter.dto.JoinDto
import com.example.kotlinplayground.join.domain.Member

interface JoinUseCase {

    fun joinMember(dto : JoinDto) : String

    fun findMember(email : String) : Member?
}