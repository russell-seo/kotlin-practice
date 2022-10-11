package com.example.kotlinplayground.join.adapter.`in`

import com.example.kotlinplayground.join.application.port.service.JwtService
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAuthenticationFilter(
    val jwtService: JwtService) : OncePerRequestFilter(){

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        var token = request.getHeader("Authorization")

        if(jwtService.validToken(token)) {
            val userInfo = jwtService.getUserInfo(token)
            val email = userInfo.get("email")
            val name = userInfo.get("name")

        }
    }
}