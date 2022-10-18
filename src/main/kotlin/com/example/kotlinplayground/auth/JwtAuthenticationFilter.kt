package com.example.kotlinplayground.auth

import com.example.kotlinplayground.auth.service.JwtService
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.validation.ValidationException

@Component
class JwtAuthenticationFilter(
    val jwtService: JwtService) : OncePerRequestFilter(){

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        var token = request.getHeader("Authorization") ?: throw Exception("Token 값이 없습니다. 로그인 한 후에 사용해주세요")

        if(!jwtService.validToken(token)) {
            throw ValidationException("유효하지 않은 토큰")
        }

        val userInfo = jwtService.getUserInfo(token)
        val email = userInfo.get("email")
        val authentication = jwtService.getAuthentication(email as String)

        SecurityContextHolder.getContext().authentication = authentication

        filterChain.doFilter(request, response)
    }

}