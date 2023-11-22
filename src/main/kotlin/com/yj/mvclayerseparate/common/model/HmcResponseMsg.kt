package com.hmcnetworks.yojic.common.model
/*
 * 정의 : 클라이언트에 넘길 커스텀 메시지
 */
class HmcResponseMsg(
    var msgCode: Int = 0, // 메시지 코드
    var showAlert: Boolean = false, // 클라이언트에게 경고창 출력여부
    var msgBody: String? = null, // 클라이언트에 넘길 메시지
)
