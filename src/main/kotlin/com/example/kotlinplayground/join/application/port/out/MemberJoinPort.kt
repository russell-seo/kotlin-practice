package com.example.kotlinplayground.join.application.port.out

import com.example.kotlinplayground.join.adapter.dto.JoinDto
import com.example.kotlinplayground.join.domain.Member

interface MemberJoinPort {

    fun registerMember(joinDto: JoinDto) : Long

    fun findMember(email: String): Member?
}