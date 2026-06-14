package com.ipManager.ipManager.config

import com.ipManager.ipManager.commons.enums.Role
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
            .cors { }
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
            }
            .authorizeHttpRequests { auth ->
                auth.requestMatchers(HttpMethod.POST, "/admin").permitAll()
                auth.requestMatchers("/auth").permitAll()

                auth.requestMatchers(HttpMethod.POST,"/beneficiaries").hasAuthority(Role.REVEREND.name)
                auth.requestMatchers(HttpMethod.DELETE,"/beneficiaries/{id}").hasAuthority(Role.REVEREND.name)
                auth.requestMatchers(HttpMethod.PATCH, "/beneficiaries/{id}").authenticated()
                auth.requestMatchers(HttpMethod.GET, "/beneficiaries").authenticated()
                auth.requestMatchers(HttpMethod.GET,"/beneficiaries/{id}").authenticated()

                auth.requestMatchers(HttpMethod.POST,"/distributions").authenticated()
                auth.requestMatchers(HttpMethod.GET,"/distributions").authenticated()
                auth.requestMatchers(HttpMethod.GET, "/baskets/stock").authenticated()
                auth.requestMatchers(HttpMethod.POST,"/baskets/stock/{quantity}").authenticated()


                auth
                    .requestMatchers(
                        "/swagger-ui/**",
                        "/swagger-ui.html",
                        "/v3/api-docs/**"
                    ).permitAll()
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