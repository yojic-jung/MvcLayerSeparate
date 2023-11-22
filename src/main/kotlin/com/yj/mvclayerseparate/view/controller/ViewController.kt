/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hmcnetworks.yojic.view.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ViewController {

    @GetMapping("/")
    fun indexPage(): String {
        return "index.html"
    }

    @GetMapping("/board")
    fun board(): String {
        return "board.html"
    }

    @GetMapping("/login")
    fun login(): String {
        return "login.html"
    }

    @GetMapping("/signup")
    fun signup(): String {
        return "signup.html"
    }
}
