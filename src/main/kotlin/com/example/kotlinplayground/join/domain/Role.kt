package com.example.kotlinplayground.join.domain

import org.springframework.security.core.authority.SimpleGrantedAuthority

enum class Role(private val role : List<SimpleGrantedAuthority>,
                private val desc : String
) {
    ADMiN(listOf(SimpleGrantedAuthority("ROLE_ADMIN")) , "어드민"),
    USER(listOf(SimpleGrantedAuthority("ROLE_USER")), "회원"),
    GUEST(listOf(SimpleGrantedAuthority("ROLE_GUEST")), "게스트");


    fun getAuthority() : List<SimpleGrantedAuthority> {
        return role
    }

    fun getDesc() : String {
        return desc
    }

}