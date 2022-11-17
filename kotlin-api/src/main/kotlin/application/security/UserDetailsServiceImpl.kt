package application.security

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import repository.MemberPort
import repository.MemberRepository

@Service
class UserDetailsServiceImpl(
    val memberPort: MemberPort
) : UserDetailsService {


    override fun loadUserByUsername(username: String): UserDetails {
        val member = memberPort.findByEmail(username)?: throw UsernameNotFoundException("존재하지 않는 유저입니다")

        return UserDetailsSecurity(member)
    }
}