package com.example.kotlinplayground.join.adapter.out

import com.example.kotlinplayground.join.adapter.dto.JoinDto
import com.example.kotlinplayground.join.domain.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
@Repository
interface MemberRepository : JpaRepository<Member, Long>{

    fun findByEmail(email : String) : Optional<Member>


}