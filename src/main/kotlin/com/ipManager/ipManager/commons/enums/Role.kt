package com.ipManager.ipManager.commons.enums

import org.springframework.security.core.authority.SimpleGrantedAuthority

enum class Role {
    REVEREND,
    PARENT,
    DEACON,
    PRIEST,
    COMMON;

    fun toGrantedAuthority() =
        SimpleGrantedAuthority(this.name)
}