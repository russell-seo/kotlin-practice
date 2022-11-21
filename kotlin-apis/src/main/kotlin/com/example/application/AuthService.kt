package com.example.application

import org.springframework.stereotype.Service
import com.example.repository.MemberPort
import com.example.security.JwtService

@Service
class AuthService(
    private val memberPort: MemberPort,
    private val jwtService: JwtService
){

    fun joinMember(req : JoinReq) : JoinRes {
        memberPort.findByEmail(req.email)?.let { throw Exception("해당 이메일이 존재합니다.") }
        val id = memberPort.save(email = req.email, name = req.name, password = req.password)

        val token = jwtService.generateToken(req.email, req.name)
        return JoinRes(id = id, token = token)
    }


    fun login(req: LoginReq) {
        memberPort.getByEmail(req.email)
    }

}