package com.example.kotlinplayground.join.adapter.out

import com.example.kotlinplayground.join.adapter.dto.JoinDto
import com.example.kotlinplayground.join.adapter.dto.LoginDto
import com.example.kotlinplayground.join.application.port.out.LoginPort
import com.example.kotlinplayground.join.application.port.out.MemberJoinPort
import com.example.kotlinplayground.join.domain.Member
import com.example.kotlinplayground.join.domain.mapToMember
import org.springframework.stereotype.Component

@Component
class MemberPersistenceAdapter(
    private val memberRepository: MemberRepository
) : MemberJoinPort, LoginPort{

    override fun registerMember(member:Member): Long {
        val save = memberRepository.save(member)
        return save.id!!

    }

    override fun findMember(email: String): Member? {
        val member = memberRepository.findByEmail(email)
        return if (member.isPresent) member.get() else null
    }

    override fun validLogin(dto: LoginDto): Member {
        val validMember = memberRepository.validMember(dto.userId, dto.password)
        return validMember
    }
}