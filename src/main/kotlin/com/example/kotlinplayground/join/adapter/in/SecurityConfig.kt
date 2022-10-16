package com.example.kotlinplayground.join.adapter.`in`

import com.example.kotlinplayground.join.application.port.service.JwtService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@EnableWebSecurity
@Configuration
class SecurityConfig(
    val jwtService: JwtService,
    val jwtAuthenticationFilter: JwtAuthenticationFilter
) : WebSecurityConfigurerAdapter(){

    @Bean
    override fun authenticationManager(): AuthenticationManager {
        return super.authenticationManager()
    }

    override fun configure(web: WebSecurity?) {
        web?.ignoring()?.antMatchers(
            "/h2-console/**",
            "/login/**",
            "/join/**",
            "/resources/**"
        )
    }

    override fun configure(http: HttpSecurity) {
        http.httpBasic()
            .disable()
            .cors().and()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/v1/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
    }
}