/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hmcnetworks.yojic.board.domain.service

/*
 * 정의 : 게시판 삭제 인터페이스
 */
interface BoardDelSvc {
    // 게시글 비공개로 전환(사용자 삭제 요청한 경우)
    fun hideBoard(boardId: Long, memId: Long): Long = 0

    // 게시글 최종 삭제(관리자 전용 또는 배치로 삭제)
    fun deleteBoard(boardId: Long): Long = 0
}
