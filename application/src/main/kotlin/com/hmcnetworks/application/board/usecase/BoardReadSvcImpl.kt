/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hmcnetworks.yojic.board.domain.service

import com.hmcnetworks.yojic.board.common.vo.BoardReadParam
import com.hmcnetworks.yojic.board.common.vo.BoardVo
import com.hmcnetworks.yojic.board.domain.repository.BoardQueryRepository
import com.hmcnetworks.yojic.common.model.HmcPage
import com.hmcnetworks.yojic.common.model.HmcPageable
import org.springframework.stereotype.Service

/*
 * 정의: 게시글 조회 구현 클래스
 */
@Service
class BoardReadSvcImpl(
    val boardQueryRepository: BoardQueryRepository
) : BoardReadSvc {
    // 게시글 번호로 한건 조회
    override fun readBoard(boardId: Long): BoardVo? {
        return boardQueryRepository.readBoard(boardId)
    }

    // 검색 조건에 따른 게시글 조회
    override fun readBoardListByReadCond(boardReadParam: BoardReadParam, hmcPageable: HmcPageable): HmcPage<BoardVo> {
        return boardQueryRepository.readBoardListByReadCond(boardReadParam, hmcPageable)
    }
}
