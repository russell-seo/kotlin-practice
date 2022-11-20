package com.example.application

import org.springframework.stereotype.Service
import com.example.repository.MemberPort

@Service
class AuthService(private val memberPort: MemberPort){

    fun joinMember(req : JoinReq)  {
        memberPort.save(email = req.email, name = req.name, password = req.password)
    }


    fun login(req: LoginReq) {
        memberPort.getByEmail(req.email)
    }

}