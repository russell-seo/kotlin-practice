package com.example.kotlinplayground.join.application.port.service

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*


class JwtService(
    @Value("\${jwt.secret}")
    private val secret : String,

    private val expiredTime : Long = 60 * 30 * 1000L
) {


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

    

}