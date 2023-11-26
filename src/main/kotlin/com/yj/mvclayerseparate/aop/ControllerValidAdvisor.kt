/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hmcnetworks.yojic.aop

import com.yj.mvclayerseparate.common.exception.tmpl.ExceptionMsgTmpl
import com.yj.mvclayerseparate.common.model.CustomResTmpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/*
 * 정의 : 모든 컨트롤러에 예외 핸들러 클래스
 */
@RestControllerAdvice
class ControllerValidAdvisor {

    // 컨트롤러 메서드 매개변수 객체 속성값 유효성 핸들러
    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun handlingModelValidException(ex: MethodArgumentNotValidException): ResponseEntity<CustomResTmpl<ExceptionMsgTmpl>> {
        // 클라이언트에 전달할 메시지(@Valid에 적용된 message)
        val clientMsg = ex.bindingResult.fieldError?.defaultMessage ?: "입력양식이 올바르지 않습니다."
        // 에러 메시지 템플릿
        val timestamp = System.currentTimeMillis()
        val errInfo = ExceptionMsgTmpl(
            statusCode = 400,
            errId = "err001-$timestamp",
            errTitle = "BAD_REQUEST",
        )
        // 에러 로그 찍기
        val errId = errInfo.errId
        println("에러 식별값 : $errId\n에러로그 : $ex")
        // 응답 객체 전달
        val resBody = CustomResTmpl<ExceptionMsgTmpl>(showMsgAlert = true, message = clientMsg, data = errInfo)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resBody)
    }
}
