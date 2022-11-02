package com.example.kotlinplayground.join.application.port.service

import com.example.kotlinplayground.auth.Role
import com.example.kotlinplayground.join.adapter.dto.JoinDto
import com.example.kotlinplayground.join.application.port.JoinUseCase
import com.example.kotlinplayground.join.application.port.out.MemberJoinPort
import com.example.kotlinplayground.join.domain.Member
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class JoinService(
    val memberJoinPort: MemberJoinPort,
    val passwordEncoder : PasswordEncoder
    ) : JoinUseCase {

    @Transactional
    override fun joinMember(dto: JoinDto) : Long{
        val member =
                Member.create(
                userId = dto.userId,
                name = dto.name,
                password = passwordEncoder.encode(dto.password),
                phone = dto.phone,
                email = dto.email,
                role = Role.USER.getDesc()
        )
        return  memberJoinPort.registerMember(member);

    }

    override fun findMember(email: String) : Member? {
        return memberJoinPort.findMember(email)
    }


}