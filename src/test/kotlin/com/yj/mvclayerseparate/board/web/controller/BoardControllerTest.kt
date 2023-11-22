package com.yj.mvclayerseparate.board.web.controller

import com.hmcnetworks.yojic.board.common.vo.BoardVo
import com.hmcnetworks.yojic.board.domain.service.BoardCreateSvc
import com.hmcnetworks.yojic.board.web.controller.BoardController
import com.hmcnetworks.yojic.board.web.dto.BoardDto
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
@SpringBootTest
class BoardControllerTest {

    @Mock
    lateinit var boardCreateSvcImpl: BoardCreateSvc

    @InjectMocks
    lateinit var boardController: BoardController

    @Test
    fun createBoardTest() {
        // Given
        val requestDto = BoardDto(
            memId = 1,
            boardTitle = "게시글 제목",
            boardContents = "게시글 내용",
        )
        val createdBoardVo = BoardVo(
            boardId = 1,
            memId = 1,
            boardTitle = "게시글 제목",
            boardContents = "게시글 내용",
            sysCreateTime = LocalDateTime.now(),
            sysUpdateTime = LocalDateTime.now(),
        )
        Mockito.`when`(boardCreateSvcImpl.createBoard(requestDto.toBoardVo())).thenReturn(createdBoardVo)

        // When
        val responseEntity: ResponseEntity<BoardDto> = boardController.createBoard(requestDto)

        // Then
        assertEquals(HttpStatus.OK, responseEntity.statusCode)
        assertEquals(createdBoardVo.boardTitle, responseEntity.body?.boardTitle)
        Mockito.verify(boardCreateSvcImpl).createBoard(requestDto.toBoardVo())
    }
}
