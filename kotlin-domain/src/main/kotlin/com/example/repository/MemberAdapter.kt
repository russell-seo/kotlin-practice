package com.example.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.example.domain.Member
import com.example.domain.QMember
import org.springframework.stereotype.Component

@Component
class MemberAdapter(
    private val memberRepository: MemberRepository,
    private val jpaQueryFactory: JPAQueryFactory
) : MemberPort {

    override fun findById(id: Long): Member? {
        val member = memberRepository.findById(id)
        return if(member.isPresent) member.get() else null
    }

    override fun getById(id: Long): Member {
        return findById(id)?: throw Exception("유저가 존재하지 않습니다.")
    }

    override fun findByEmail(email: String): Member? {
        val member = QMember.member
        return jpaQueryFactory.selectFrom(member)
                              .where(member.email.eq(email))
                              .fetchOne()

    }

    override fun getByEmail(email: String): Member {
       return findByEmail(email)?: throw Exception("존재하지 않는 이메일 입니다.")
    }

    override fun save(email: String, password: String, name : String) : Long {
        val member = Member.create(email= email, password = password, name = name)
        val savedMember = memberRepository.save(member)
        return savedMember.id!!
    }


}