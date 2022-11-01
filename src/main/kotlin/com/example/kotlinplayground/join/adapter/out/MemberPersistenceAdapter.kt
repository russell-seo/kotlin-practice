package com.example.kotlinplayground.join.adapter.out

import com.example.kotlinplayground.join.adapter.dto.JoinDto
import com.example.kotlinplayground.join.adapter.dto.LoginDto
import com.example.kotlinplayground.join.application.port.out.LoginPort
import com.example.kotlinplayground.join.application.port.out.MemberJoinPort
import com.example.kotlinplayground.join.domain.Member
import com.example.kotlinplayground.join.domain.mapToMember
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.security.core.userdetails.UsernameNotFoundException
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
        val member = memberRepository.findByEmail(email)?.let {
            it
        }
            ?: throw UsernameNotFoundException("해당 유저가 없습니다.")
        return member
    }

    override fun validLogin(dto: LoginDto): Member? {
        val member = memberRepository.validMember(dto.userId, dto.password)
            ?.let {
                it
            }
            ?: throw IllegalArgumentException("입력하신 정보가 틀렸습니다.")

        return member
    }
}