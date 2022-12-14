package com.example.application

data class JoinRes(
    val id : Long,
    val token : String
)

data class JoinReq(
    val email : String,
    val password : String,
    val name : String
)

data class LoginReq(
    val email: String,
    val password: String
)
