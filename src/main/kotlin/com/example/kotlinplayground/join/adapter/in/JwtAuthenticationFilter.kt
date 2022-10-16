package com.example.kotlinplayground.join.adapter.`in`

import com.example.kotlinplayground.join.application.port.service.JwtService
import io.jsonwebtoken.Claims
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.util.*
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
        var token = request.getHeader("Authorization") ?: ""

        if(!jwtService.validToken(token)) {
            throw ValidationException("유효하지 않은 토큰")
        }
            val userInfo = jwtService.getUserInfo(token)


        UsernamePasswordAuthenticationToken(userInfo.subject, token, )



    }

    private fun hasAccessToken(request : HttpServletRequest) : Boolean {
        return Objects.nonNull(request.getHeader("Authorization"))
    }
}