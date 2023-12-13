package com.hmcnetworks.yojic.members.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class MembersRole(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val memRoleId: Long = 0,
    val memId: Long = 0,
    val enabled: Boolean,
    val roleName: String = "",
    @CreationTimestamp
    val sysUpdateTime: LocalDateTime = LocalDateTime.now(),
    @UpdateTimestamp
    val sysCreateTime: LocalDateTime = LocalDateTime.now()
)
