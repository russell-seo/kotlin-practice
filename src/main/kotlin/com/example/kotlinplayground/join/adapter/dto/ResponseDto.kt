package com.example.kotlinplayground.join.adapter.dto

data class LoginResponseDto(

    var token : String,
    var userId : Long
)

data class JoinResponseDto(
     var userId : Long,
     var message : String
)
