/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hmcnetworks.yojic.board.domain.service

import com.hmcnetworks.yojic.board.common.vo.BoardVo
import com.hmcnetworks.yojic.board.domain.repository.BoardQueryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
/*
 * 정의 : 게시글 수정 서비스 클래스
 */
@Service
class BoardUpdtSvcImpl(
    val boardQueryRepository: BoardQueryRepository,
) : BoardUpdtSvc {
    @Transactional
    override fun updateBoard(boardVo: BoardVo): Long {
        // 게시글 수정
        return boardQueryRepository.updateBoard(boardVo)
    }
}
