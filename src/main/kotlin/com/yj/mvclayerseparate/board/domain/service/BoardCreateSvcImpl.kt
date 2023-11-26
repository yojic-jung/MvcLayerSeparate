/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hmcnetworks.yojic.board.domain.service

import com.yj.mvclayerseparate.board.domain.vo.BoardVo
import com.yj.mvclayerseparate.board.db.repository.BoardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardCreateSvcImpl(
    @Autowired
    val boardRepository: BoardRepository,
) : BoardCreateSvc {
    @Transactional
    override fun createBoard(boardVo: BoardVo): BoardVo {
        // 서비스 validation 체크
        // boardId 있는지 체크
        // boardId 있는 게시글 접근 금지(오직 생성 목적의 함수)
        var boardEntity = boardRepository.save(boardVo.toEntity())
        return BoardVo.fromEntityToVo(boardEntity)
    }
}
