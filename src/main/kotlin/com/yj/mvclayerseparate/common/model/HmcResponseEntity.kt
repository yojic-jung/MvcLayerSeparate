package com.hmcnetworks.yojic.common.model

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.MultiValueMap
/*
 * 정의 : 응답용 객체
 */
class HmcResponseEntity<T>(
    status: HttpStatus,
    headers: MultiValueMap<String, String>? = null,
    body: T? = null,
    var hmcResMsg: HmcResponseMsg? = null,
) : ResponseEntity<T>(body, headers, status) {

    companion object {
        fun <T> ok(
            body: T,
            headers: MultiValueMap<String, String>? = null,
        ): HmcResponseEntity<T> {
            return HmcResponseEntity(HttpStatus.OK, headers, body)
        }

        fun responseHmcMsg(
            status: HttpStatus,
            hmcResMsg: HmcResponseMsg
        ): HmcResponseEntity<HmcResponseMsg> {
            return HmcResponseEntity(status, body = hmcResMsg)
        }
    }
}
