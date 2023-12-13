/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hmcnetworks.yojic.members.dto

import com.hmcnetworks.yojic.members.entity.Members
import com.hmcnetworks.yojic.members.entity.MembersPrivate
import java.time.LocalDateTime

class MembersDto(
    var memId: Long = 0,
    var email: String,
    var passwd: String,
    var humanStatus: Int,
    var failCnt: Int,
    var lastFailTime: String,
    var sysUpdateTime: LocalDateTime,
    var sysCreateTime: LocalDateTime,

    // MembersPrivate
    var memPrvcId: Long = 0,
    var userName: String,
    var birth: String,
    var phone: String,
) {
    fun toMembersEntity(): Members = Members(
        memId = memId,
        email = email,
        passwd = passwd,
    )
    fun toMembersPrivateEntity(): MembersPrivate = MembersPrivate(
        memPrvcId = memPrvcId,
        memId = memId,
        userName = userName,
        birth = birth,
        phone = phone,
    )
}
