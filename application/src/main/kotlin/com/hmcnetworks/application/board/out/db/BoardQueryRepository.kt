/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hmcnetworks.yojic.board.domain.repository

import com.hmcnetworks.yojic.board.common.vo.BoardReadParam
import com.hmcnetworks.yojic.board.common.vo.BoardVo
import com.hmcnetworks.yojic.common.model.HmcPage
import com.hmcnetworks.yojic.common.model.HmcPageable
import org.springframework.stereotype.Repository

@Repository
interface BoardQueryRepository {
    fun updateBoard(boardVo: BoardVo): Long
    fun chngBoardVisibility(boardId: Long, memId: Long, visibleStts: Int): Long
    fun readBoard(boardId: Long): BoardVo?
    fun readBoardListByReadCond(boardReadParam: BoardReadParam, hmcPageable: HmcPageable): HmcPage<BoardVo>
}
