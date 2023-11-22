/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hmcnetworks.yojic.aop

import com.hmcnetworks.yojic.common.model.HmcResponseEntity
import com.hmcnetworks.yojic.common.model.HmcResponseMsg
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
/*
 * 정의 : 모든 컨트롤러에 적용될 유효성 검사 클래스
 */
@RestControllerAdvice
class ControllerValidAdvisor {
    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun handlingModelValidException(ex: MethodArgumentNotValidException): HmcResponseEntity<HmcResponseMsg> {
        val resMsg = HmcResponseMsg(0, false, ex.toString())
        return HmcResponseEntity.responseHmcMsg(HttpStatus.BAD_REQUEST, resMsg)
    }
}
