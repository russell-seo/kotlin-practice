package application.security

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtAuthenticationFilter(
    val jwtService: JwtService) : OncePerRequestFilter(){
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        var token = request.getHeader("Authorization") ?: ""

        if(!token.isNullOrBlank() && jwtService.validToken(token)) {
            val userInfo = jwtService.getUserInfo(token)
            val email = userInfo["email"]
            val authentication = jwtService.getAuthentication(email as String)

            SecurityContextHolder.getContext().authentication = authentication
        }


        filterChain.doFilter(request, response)
    }

}