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
import com.hmcnetworks.yojic.common.model.HmcResponseEntity
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController(
    var boardCreateSvcImpl: BoardCreateSvc
) {
    @PostMapping("/createBoard")
    fun createBoard(@Valid @RequestBody boardDto: BoardDto): HmcResponseEntity<BoardDto> {
        boardDto.memId = 1 // 하드코딩 추후 멤버 개발되면 수정 예정
        var boardVo = boardCreateSvcImpl.createBoard(boardDto.toBoardVo())
        return HmcResponseEntity.ok(BoardDto.fromVoToDto(boardVo))
    }
}
