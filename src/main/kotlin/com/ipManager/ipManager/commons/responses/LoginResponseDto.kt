package com.ipManager.ipManager.commons.responses

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

data class LoginResponseDto (
    val email:String,
    val role: List<GrantedAuthority>
)
