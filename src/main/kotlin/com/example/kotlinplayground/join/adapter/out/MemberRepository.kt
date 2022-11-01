package com.example.kotlinplayground.join.adapter.out

import com.example.kotlinplayground.join.adapter.dto.JoinDto
import com.example.kotlinplayground.join.domain.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*
@Repository
interface MemberRepository : JpaRepository<Member, Long>{

    fun findByEmail(email : String?) : Member?

    @Query("select m from Member m where m.email = :userId and m.password = :password")
    fun validMember(userId : String, password : String) : Member?
}