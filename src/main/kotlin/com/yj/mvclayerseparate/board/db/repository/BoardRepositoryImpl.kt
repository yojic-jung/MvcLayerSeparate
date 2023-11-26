package com.yj.mvclayerseparate.board.db.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.yj.mvclayerseparate.board.db.entity.Board
import com.yj.mvclayerseparate.board.db.entity.QBoard
import com.yj.mvclayerseparate.board.domain.vo.BoardVo
import org.springframework.stereotype.Repository

@Repository
class BoardRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) {
    fun findAll(): List<Board> {
        return jpaQueryFactory.selectFrom(QBoard.board).fetch()
    }

    fun updateBoard(boardVo: BoardVo): Long {
        return jpaQueryFactory
            .update(QBoard.board)
            .set(QBoard.board.boardTitle, boardVo.boardTitle)
            .set(QBoard.board.boardContents, boardVo.boardContents)
            .where(
                QBoard.board.boardId.eq(boardVo.boardId),
                QBoard.board.memId.eq(boardVo.memId),
            )
            .execute()
    }
}
