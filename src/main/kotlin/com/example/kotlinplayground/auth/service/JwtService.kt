package com.example.kotlinplayground.auth.service

import com.example.kotlinplayground.join.domain.Member
import com.example.kotlinplayground.auth.Role
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtService(
    @Value("\${jwt.secret}")
    private val secret : String,
    val userDetailServiceImpl: UserDetailServiceImpl
) {
    private val expiredTime : Long = 60 * 30 * 1000L

    fun generateToken(email : String, name : String) : String {
        return Jwts.builder()
            .setIssuedAt(Date())
            .claim("email", email)
            .claim("name", name)
            .setExpiration(Date(System.currentTimeMillis()+ expiredTime))
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact()
    }

    fun getUserInfo(token : String) : Claims {
        return Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)
            .body
    }

    fun validToken(token : String) : Boolean {
        val body =
            Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .body
        return !body.expiration.before(Date())
    }

    fun getAuthentication(email: String) : Authentication {
        val userDetails = userDetailServiceImpl.loadUserByUsername(email)
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

}