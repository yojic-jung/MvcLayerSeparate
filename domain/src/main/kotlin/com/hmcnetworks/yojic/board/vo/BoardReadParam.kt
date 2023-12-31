/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hmcnetworks.yojic.board.common.vo

import java.time.LocalDateTime

/*
 * 정의 : 게시판 조회 조건 파라미터 객체(VO)
 * 사용법 : 정적 팩토리 메서드 통해 조회 조건 파라미터 만들어서 사용(생성자 사용X)
 */
data class BoardReadParam(
    /*
     * readSttsCode : 0 (전체 조회)
     *                1 (특정 회원 글 제외 전체 조회)
     *                2 (특정 회원 글만)
     */
    var readSttsCode: Int = 0,
    var memId: Long = 0, // readSttsCode가 1 또는 2일 때 특정 회원의 회원ID값 (자기 자신 가능)
    var createTimeStrt: LocalDateTime? = null, // 조회 시작 날짜(게시글 생성 날짜 기준)
    var createTimeEnd: LocalDateTime? = null, // 조회 종료 날짜(게시글 생성 날짜 기준)
    var sortByLatestCreation: Boolean = true, // 정렬조건(생성 날짜 최신순 : true, 오래된순 : false)
) {
    init {
        // 생성날짜 둘 중에 하나라도 null이면 둘다 null 처리
        if (createTimeStrt == null || createTimeEnd == null) {
            this.createTimeStrt = null
            this.createTimeEnd = null
        }
    }
}
