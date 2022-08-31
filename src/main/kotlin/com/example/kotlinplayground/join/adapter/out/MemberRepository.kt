package com.example.kotlinplayground.join.adapter.out

import com.example.kotlinplayground.join.adapter.dto.JoinDto
import com.example.kotlinplayground.join.domain.Member
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MemberRepository : JpaRepository<Member, Long>{

    fun findByEmail(email : String) : Optional<Member>
}