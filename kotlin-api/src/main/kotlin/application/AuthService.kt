package application

import org.springframework.stereotype.Service
import repository.MemberPort

@Service
class AuthService(private val memberPort: MemberPort){

    fun joinMember(req : JoinReq) : JoinRes{
    }


    fun login(req: LoginReq) {
        memberPort.getByEmail(req.email)
    }

}