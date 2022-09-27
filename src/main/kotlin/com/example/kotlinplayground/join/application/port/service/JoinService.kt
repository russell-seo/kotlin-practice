package com.example.kotlinplayground.join.application.port.service

import com.example.kotlinplayground.join.adapter.dto.JoinDto
import com.example.kotlinplayground.join.application.port.JoinUseCase
import com.example.kotlinplayground.join.application.port.out.MemberJoinPort
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class JoinService(private val memberJoinPort: MemberJoinPort) : JoinUseCase {

    @Transactional
    override fun joinMember(dto: JoinDto) {
        memberJoinPort.joinMembers(dto);
    }


}