package com.example.kotlinplayground.join.domain

import org.springframework.security.core.authority.SimpleGrantedAuthority

enum class Role(private val role : SimpleGrantedAuthority,
                private val desc : String
) {
    ADMiN(SimpleGrantedAuthority("ROLE_ADMIN"), "어드민"),
    USER(SimpleGrantedAuthority("ROLE_USER"), "회원"),
    GUEST(SimpleGrantedAuthority("ROLE_GUEST"), "게스트");


    fun getAuthority() : SimpleGrantedAuthority {
        return role
    }

    fun getDesc() : String {
        return desc
    }

}