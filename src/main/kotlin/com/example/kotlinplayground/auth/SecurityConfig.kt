package com.example.kotlinplayground.auth

import com.example.kotlinplayground.auth.service.JwtService
import com.example.kotlinplayground.auth.service.UserDetailServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@EnableWebSecurity
@Configuration
class SecurityConfig(
        val jwtService: JwtService,
        val jwtAuthenticationFilter: JwtAuthenticationFilter,
        val userDetailServiceImpl: UserDetailServiceImpl,
        val jwtAuthenticationEntryPoint: JwtAuthenticationEntryPoint
) {



    @Bean
    fun passwordEncoder() : PasswordEncoder {
        return BCryptPasswordEncoder()
    }


    @Bean
    fun filterChain(http: HttpSecurity) : SecurityFilterChain {
        http.anonymous().and()
            .csrf().disable()
            .cors().and()
            .authorizeRequests()
            .antMatchers("/api/v1/join").permitAll()
//            .antMatchers("/api/v1/join").permitAll()
            .anyRequest().authenticated()
            .and()
            .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .userDetailsService(userDetailServiceImpl)

        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
        return http.build()
    }

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer? {
        return WebSecurityCustomizer { web: WebSecurity ->
            web.ignoring()
                .antMatchers("/h2-console/**")
//                    .antMatchers("/join")
                .antMatchers("/api/v1/**")
                .antMatchers("/resources/**")
        }
    }



}