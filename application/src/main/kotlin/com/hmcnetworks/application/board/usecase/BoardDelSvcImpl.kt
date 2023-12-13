/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hmcnetworks.yojic.board.domain.service

import com.hmcnetworks.yojic.board.domain.repository.BoardQueryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
/*
 * 정의 : 게시판 삭제 서비스
 */
@Service
class BoardDelSvcImpl(
    private val boardQueryRepository: BoardQueryRepository,
) : BoardDelSvc {

    // 게시글 비공개로 전환(클라이언트단 사용자가 삭제 요청한 경우)
    @Transactional
    override fun hideBoard(boardId: Long, memId: Long): Long {
        // 사용자가 삭제 요청한 게시글 비공개로 전환
        return boardQueryRepository.chngBoardVisibility(boardId, memId, 1)
    }
}
