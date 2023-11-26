/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.yj.mvclayerseparate.board.domain.vo

import com.yj.mvclayerseparate.board.db.entity.Board
import java.time.LocalDateTime

data class BoardVo(
    val boardId: Long = 0,
    val memId: Long = 0,
    val boardTitle: String,
    val boardContents: String,
    val sysUpdateTime: LocalDateTime? = null,
    val sysCreateTime: LocalDateTime? = null,
) {
    fun toEntity(): Board = Board(
        boardId = boardId,
        memId = memId,
        boardTitle = boardTitle,
        boardContents = boardContents,
    )

    companion object {
        fun fromEntityToVo(boardEntity: Board): BoardVo = BoardVo(
            boardId = boardEntity.boardId,
            memId = boardEntity.memId,
            boardTitle = boardEntity.boardTitle,
            boardContents = boardEntity.boardContents,
            sysUpdateTime = boardEntity.sysUpdateTime,
            sysCreateTime = boardEntity.sysCreateTime,
        )
    }
}
