package com.example.kotlinplayground.join.application.port.out

import com.example.kotlinplayground.join.adapter.dto.JoinDto
import org.springframework.stereotype.Component

interface MemberJoinPort {

    fun joinMembers(joinDto: JoinDto) : Long
}