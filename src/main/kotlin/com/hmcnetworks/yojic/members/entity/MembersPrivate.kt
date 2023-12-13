package com.hmcnetworks.yojic.members.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
open class MembersPrivate(
    memPrvcId: Long = 0,
    memId: Long = 0,
    userName: String,
    birth: String = "",
    phone: String = "",
    @CreationTimestamp
    open val sysUpdateTime: LocalDateTime = LocalDateTime.now(),
    @UpdateTimestamp
    open val sysCreateTime: LocalDateTime = LocalDateTime.now()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var memPrvcId: Long = memPrvcId
        protected set
    open var memId: Long = memId
        protected set
    open var userName: String = userName
        protected set
    open var birth: String = birth
        protected set
    open var phone: String = phone
        protected set
}
