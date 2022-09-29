package com.example.kotlinplayground.join.application.port.service

import com.example.kotlinplayground.join.adapter.dto.JoinDto
import com.example.kotlinplayground.join.application.port.JoinUseCase
import com.example.kotlinplayground.join.application.port.out.MemberJoinPort
import com.example.kotlinplayground.join.domain.Member
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class JoinService(
    private val memberJoinPort: MemberJoinPort
    ) : JoinUseCase {

    @Transactional
    override fun joinMember(dto: JoinDto) {
        val joinMembers = memberJoinPort.registerMember(dto);
    }

    override fun findMember(email: String) : Member? {
        return memberJoinPort.findMember(email)
    }
}