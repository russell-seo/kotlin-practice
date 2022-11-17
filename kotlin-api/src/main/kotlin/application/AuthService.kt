package application

import org.springframework.stereotype.Service
import repository.MemberPort

@Service
class AuthService(private val memberPort: MemberPort){

    fun joinMember(req : JoinReq) : JoinRes{
        memberPort.save(email = req.email, name = req.name, password = req.password)
    }


    fun login(req: LoginReq) {
        memberPort.getByEmail(req.email)
    }

}