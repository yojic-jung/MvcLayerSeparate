package com.yj.mvclayerseparate.common.model

import java.time.LocalDateTime

data class CustomResTmpl<T>(
    val showMsgAlert: Boolean = false, // message내용 클라이언트단에서 경고창 출력 여부
    val message: String? = null, // 클라이언트에 전달할 메시지 내용
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val data: T? = null, // 전달 객체
)
