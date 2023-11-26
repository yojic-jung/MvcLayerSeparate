package com.yj.mvclayerseparate.board.domain.service

import com.yj.mvclayerseparate.board.domain.vo.BoardVo

interface BoardUpdtSvc {
    fun updateBoard(boardVo: BoardVo): Long
}