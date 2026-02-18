package com.ipManager.ipManager.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig(
    private val authConfig: AuthenticationConfiguration,
    private val customerUserDetails: CustomUserDetails
) {
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun securityFilter(http: HttpSecurity): SecurityFilterChain {
        return http.authorizeHttpRequests { auth ->
            auth.requestMatchers("/**").permitAll()
            auth.requestMatchers("/login").permitAll()
        }.csrf { it -> it.disable() }
            .build()
    }

    @Bean
    fun userDetailsService(): UserDetailsService {
        val user = User.builder().username("name").password("password").build()
        return InMemoryUserDetailsManager(user)
    }

    @Bean
    fun authManager(http: HttpSecurity): AuthenticationManager {
        val builder = http.getSharedObject(AuthenticationManagerBuilder::class.java)
           builder.userDetailsService(customerUserDetails)
            .passwordEncoder(passwordEncoder())
        return builder.build()
    }
}