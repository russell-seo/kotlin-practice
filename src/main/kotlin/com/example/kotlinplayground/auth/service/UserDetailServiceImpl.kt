package com.example.kotlinplayground.auth.service

import com.example.kotlinplayground.auth.user.UserDetailsSecurity
import com.example.kotlinplayground.join.adapter.out.MemberRepository
import com.example.kotlinplayground.join.domain.Member
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailServiceImpl(
        val memberRepository: MemberRepository
) : UserDetailsService {


    override fun loadUserByUsername(username: String?): UserDetails {
        println("memberRepository = 1")
        val member = memberRepository.findByEmail(username)?: throw UsernameNotFoundException("존재하지 않는 유저입니다")

        return UserDetailsSecurity(member)
    }
}