package com.ipManager.ipManager.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
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
        return http
            .csrf { it.disable() }
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
            }
            .authorizeHttpRequests { auth ->
                auth.requestMatchers(HttpMethod.POST, "/admin").authenticated()
                auth.requestMatchers("/auth").permitAll()
                auth.requestMatchers("/beneficiaries").permitAll()
                auth.requestMatchers(HttpMethod.PATCH, "/beneficiaries/{id}").permitAll()
                auth.requestMatchers("/beneficiaries/disable/{id}").permitAll()
            }
            .securityContext {
                it.requireExplicitSave(false)
            }
            .logout {
                it.logoutUrl("/auth/logout")
                it.invalidateHttpSession(true)
                it.deleteCookies("JSESSIONID")
                it.logoutSuccessHandler { _, response, _ ->
                    response.status = 200
                }
            }
            .build()
    }

    @Bean
    fun authManager(http: HttpSecurity): AuthenticationManager {
        val builder = http.getSharedObject(AuthenticationManagerBuilder::class.java)
        builder.userDetailsService(customerUserDetails)
            .passwordEncoder(passwordEncoder())
        return builder.build()
    }

}