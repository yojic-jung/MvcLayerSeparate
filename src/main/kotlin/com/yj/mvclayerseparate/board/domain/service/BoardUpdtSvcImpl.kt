package com.yj.mvclayerseparate.board.domain.service

import com.yj.mvclayerseparate.board.db.repository.BoardRepositoryImpl
import com.yj.mvclayerseparate.board.domain.vo.BoardVo
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class BoardUpdtSvcImpl(
    private val boardRepositoryImpl: BoardRepositoryImpl,
) : BoardUpdtSvc {

    @Transactional
    override fun updateBoard(boardVo: BoardVo): Long {
        return boardRepositoryImpl.updateBoard(boardVo)
    }
}
