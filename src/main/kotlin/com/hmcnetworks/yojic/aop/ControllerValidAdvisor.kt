/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hmcnetworks.yojic.aop

import com.hmcnetworks.yojic.common.exception.tmpl.ExceptionCode
import com.hmcnetworks.yojic.common.exception.tmpl.ExceptionMsgTmpl
import com.hmcnetworks.yojic.common.model.CustomResTmpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException

/*
 * 정의 : 모든 컨트롤러에 예외 핸들러 클래스
 */
@RestControllerAdvice
class ControllerValidAdvisor {

    // 컨트롤러 메서드 매개변수 객체 속성값 유효성 핸들러
    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun handlingModelValidException(ex: MethodArgumentNotValidException): ResponseEntity<CustomResTmpl<ExceptionMsgTmpl>> {
        // 클라이언트에 전달할 메시지(@Valid에 적용된 message)
        var clientMsg = ex.bindingResult.fieldError?.defaultMessage ?: "입력양식이 올바르지 않습니다."
        if (ex.bindingResult.fieldError?.isBindingFailure == true) clientMsg = "요청 형식이 올바르지 않습니다."
        // 예외 메시지 템플릿 작성
        val exCode = ExceptionCode.INVALID_OBJECT_PROPERTY
        val exInfo = ExceptionMsgTmpl.makeExceptionMsg(exCode)
        // 예외 로그 찍기
        println("errInfo : $exInfo \nerrDesc : $ex")
        // 응답 객체 전달
        val resBody = CustomResTmpl<ExceptionMsgTmpl>(showMsgAlert = true, message = clientMsg, data = exInfo)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resBody)
    }

    @ExceptionHandler(value = [MissingServletRequestParameterException::class])
    fun handlingMissingRequestParameterException(ex: MissingServletRequestParameterException): ResponseEntity<CustomResTmpl<ExceptionMsgTmpl>> {
        // 클라이언트에 전달할 메시지(@Valid에 적용된 message)
        val clientMsg = "유효한 요청이 아닙니다."
        // 예외 메시지 템플릿 작성
        val exCode = ExceptionCode.MISSING_REQUEST_PARAM
        val exInfo = ExceptionMsgTmpl.makeExceptionMsg(exCode)
        // 예외 로그 찍기
        println("errInfo : $exInfo \nerrDesc : $ex")
        // 응답 객체 전달
        val resBody = CustomResTmpl<ExceptionMsgTmpl>(showMsgAlert = true, message = clientMsg, data = exInfo)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resBody)
    }

    @ExceptionHandler(value = [MethodArgumentTypeMismatchException::class])
    fun handlingMethodArgumentTypeMismatchException(ex: MethodArgumentTypeMismatchException): ResponseEntity<CustomResTmpl<ExceptionMsgTmpl>> {
        // 클라이언트에 전달할 메시지(@Valid에 적용된 message)
        val clientMsg = "유효한 요청이 아닙니다."
        // 예외 메시지 템플릿 작성
        val exCode = ExceptionCode.PARAM_TYPE_MISS_MATCH
        val exInfo = ExceptionMsgTmpl.makeExceptionMsg(exCode)
        // 예외 로그 찍기
        println("errInfo : $exInfo \nerrDesc : $ex")
        // 응답 객체 전달
        val resBody = CustomResTmpl<ExceptionMsgTmpl>(showMsgAlert = true, message = clientMsg, data = exInfo)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resBody)
    }
}
