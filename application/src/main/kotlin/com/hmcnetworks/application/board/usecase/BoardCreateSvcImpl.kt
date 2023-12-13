/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hmcnetworks.yojic.board.domain.service

import com.hmcnetworks.yojic.board.common.vo.BoardVo
import com.hmcnetworks.yojic.board.domain.repository.BoardRepository
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
        var boardEntity = boardRepository.save(boardVo.toEntity())
        return BoardVo.fromEntityToVo(boardEntity)
    }
}
