/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.yj.mvclayerseparate.board.db.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
open class Board(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var boardId: Long = 0,
    open var memId: Long = 0,
    open var boardTitle: String = "",
    open var boardContents: String = "",
    @CreationTimestamp
    open var sysUpdateTime: LocalDateTime = LocalDateTime.now(),
    @UpdateTimestamp
    open var sysCreateTime: LocalDateTime = LocalDateTime.now(),
)
