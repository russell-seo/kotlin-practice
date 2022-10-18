package com.example.kotlinplayground.auth.user

import com.example.kotlinplayground.join.domain.Member
import com.example.kotlinplayground.auth.Role
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails

data class UserDetailsSecurity(
        val member : Member
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority>{
        return AuthorityUtils.createAuthorityList(Role.USER.getDesc())
    }

    override fun getPassword(): String {
        return member.password
    }

    override fun getUsername(): String {
        return member.name
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}

