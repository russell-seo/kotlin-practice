package com.example.kotlinplayground.join.adapter.out

import com.example.kotlinplayground.join.adapter.dto.JoinDto
import com.example.kotlinplayground.join.application.port.out.MemberJoinPort
import com.example.kotlinplayground.join.domain.Member
import com.example.kotlinplayground.join.domain.mapToMember
import lombok.RequiredArgsConstructor

@RequiredArgsConstructor
class MemberPersistenceAdapter(
    private val memberRepository: MemberRepository
) : MemberJoinPort{

    override fun joinMembers(dto: JoinDto): Long {
        memberRepository.findByEmail(dto.email)
        var member = mapToMember(dto)
        val save = memberRepository.save(member)
        return save.id!!

    }

}