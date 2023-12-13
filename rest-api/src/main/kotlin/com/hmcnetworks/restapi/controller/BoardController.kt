/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hmcnetworks.yojic.board.web.controller

import com.hmcnetworks.yojic.board.domain.service.BoardCreateSvc
import com.hmcnetworks.yojic.board.web.dto.BoardDto
import com.hmcnetworks.yojic.common.model.CustomResTmpl
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController(
    var boardCreateSvcImpl: BoardCreateSvc,
) {
    @PostMapping("/createBoard")
    fun createBoard(
        @Valid @RequestBody
        boardDto: BoardDto,
    ): ResponseEntity<CustomResTmpl<BoardDto>> {
        boardDto.memId = 1 // 하드코딩 추후 회원관리 개발되면 수정 예정
        val boardVo = boardCreateSvcImpl.createBoard(boardDto.toBoardVo())
        val resBoardDto = BoardDto.fromVoToDto(boardVo)
        return ResponseEntity.ok(CustomResTmpl<BoardDto>(data = resBoardDto))
    }
}
