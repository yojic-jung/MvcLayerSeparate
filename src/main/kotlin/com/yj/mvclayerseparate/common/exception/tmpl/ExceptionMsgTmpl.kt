package com.yj.mvclayerseparate.common.exception.tmpl

/*
 * 정의 : 에러 메시지 공통 클래스
 * 용도 : 클라이언트에 전달할 에러 메시지(에러 식별할 수 있는 최소한 정보만 제공)
 */
class ExceptionMsgTmpl(
    val statusCode: Int,
    val errId: String, // 서버에서 에러 식별하기 위한 고유 정보
    val errTitle: String,
)
