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
import com.hmcnetworks.yojic.board.domain.entity.QBoard
import com.hmcnetworks.yojic.common.model.HmcPage
import com.hmcnetworks.yojic.common.model.HmcPageImpl
import com.hmcnetworks.yojic.common.model.HmcPageable
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.core.types.Projections
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

/*
 * 정의 : 게시판 쿼리 리포지토리
 */
@Repository
class BoardQueryRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : BoardQueryRepository {

    // 게시글 변경 메서드
    override fun updateBoard(boardVo: BoardVo): Long {
        val board = QBoard.board
        return jpaQueryFactory
            .update(board)
            .set(board.boardTitle, boardVo.boardTitle)
            .set(board.boardContents, boardVo.boardContents)
            .set(board.sysUpdateTime, LocalDateTime.now())
            .where(
                board.boardId.eq(boardVo.boardId),
                board.memId.eq(boardVo.memId),
            )
            .execute()
    }

    // 게시글 공개/비공개 여부 변경 메서드
    override fun chngBoardVisibility(boardId: Long, memId: Long, visibleStts: Int): Long {
        val board = QBoard.board
        return jpaQueryFactory
            .update(board)
            .set(board.visibleStts, visibleStts)
            .where(
                board.boardId.eq(boardId),
                board.memId.eq(memId),
            )
            .execute()
    }

    // 게시글 boardId로 조회
    override fun readBoard(boardId: Long): BoardVo? {
        val board = QBoard.board
        return jpaQueryFactory
            .select(
                Projections.fields(
                    BoardVo::class.java,
                    board.boardId,
                    board.boardTitle,
                    board.boardContents,
                    board.sysCreateTime,
                    board.sysUpdateTime,
                ),
            ).from(board)
            .where(
                board.boardId.eq(boardId),
                board.visibleStts.eq(0),
            )
            .fetchOne()
    }

    // 게시글 조회 조건에 의해 조회
    override fun readBoardListByReadCond(boardReadParam: BoardReadParam, hmcPageable: HmcPageable): HmcPage<BoardVo> {
        val board = QBoard.board
        val contents: List<BoardVo> = jpaQueryFactory
            .select(
                Projections.fields(
                    BoardVo::class.java,
                    board.boardId,
                    board.boardTitle,
                    board.boardContents,
                    board.sysCreateTime,
                    board.sysUpdateTime,
                ),
            ).from(board)
            .where(
                memIdEqOrNotEq(boardReadParam.readSttsCode, boardReadParam.memId),
                boardCreateTimeBetween(boardReadParam.createTimeStrt, boardReadParam.createTimeEnd),
                board.visibleStts.eq(0),
            ).orderBy(sortCreateTime(boardReadParam.sortByLatestCreation))
            .offset(hmcPageable.getOffset())
            .limit(hmcPageable.pageSize)
            .fetch()

        // 첫 페이지 조회시 조회된 게시글의 갯수가 페이지 사이즈 보다 작은 경우, 전체 게시글 갯수는 조회된 게시글의 갯수
        return if (hmcPageable.pageNumber.toInt() == 0 && contents.size < hmcPageable.pageSize) {
            HmcPageImpl(contents, hmcPageable, contents.size.toLong())
        } else {
            val contentsCnt: Long = jpaQueryFactory
                .select(
                    board.count(),
                ).from(board)
                .where(
                    memIdEqOrNotEq(boardReadParam.readSttsCode, boardReadParam.memId),
                    boardCreateTimeBetween(boardReadParam.createTimeStrt, boardReadParam.createTimeEnd),
                    board.visibleStts.eq(0),
                ).orderBy(sortCreateTime(boardReadParam.sortByLatestCreation))
                .fetchFirst()
            HmcPageImpl(contents, hmcPageable, contentsCnt)
        }
    }

    fun memIdEqOrNotEq(readSttsCode: Int, memId: Long): BooleanExpression? {
        return when (readSttsCode) {
            1 -> QBoard.board.memId.ne(memId) // readSttsCode=1인 경우 해당 회원 글 제외
            2 -> QBoard.board.memId.eq(memId) // readSttsCode=2인 경우 해당 회원 글만
            else -> null
        }
    }

    fun boardCreateTimeBetween(createTimeStrt: LocalDateTime?, createTimeEnd: LocalDateTime?): BooleanExpression? {
        return if (createTimeStrt != null && createTimeEnd != null) {
            QBoard.board.sysCreateTime.between(createTimeStrt, createTimeEnd)
        } else {
            null
        }
    }

    fun sortCreateTime(sortByLatestCreation: Boolean): OrderSpecifier<LocalDateTime>? {
        return if (sortByLatestCreation) {
            QBoard.board.sysCreateTime.desc()
        } else {
            QBoard.board.sysCreateTime.asc()
        }
    }
}
