package com.example.security
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import com.example.repository.MemberPort

@Service
class UserDetailsServiceImpl(
    private val memberPort: MemberPort
) : UserDetailsService {


    override fun loadUserByUsername(username: String): UserDetails {
        val member = memberPort.findByEmail(username)?: throw UsernameNotFoundException("존재하지 않는 유저입니다")



        return User(
            member.id.toString(),
            member.password,
            Role.USER.getAuthority())
    }
}