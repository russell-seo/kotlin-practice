package com.example.adapter

import com.example.ApiResponse
import com.example.application.AuthService
import com.example.application.JoinReq
import com.example.application.JoinRes
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(
    private val authService: AuthService
) {

    @PostMapping("/api/v1/join")
    fun join(@RequestBody req: JoinReq) : ApiResponse<JoinRes>{
        val res = authService.joinMember(req)
        return ApiResponse.ok(res)

    }


}