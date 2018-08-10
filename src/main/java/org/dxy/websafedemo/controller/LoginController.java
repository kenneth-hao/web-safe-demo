package org.dxy.websafedemo.controller;

import org.dxy.websafedemo.util.Consts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(Consts.URL.LOGIN)
public class LoginController {

    @GetMapping
    public String execGet(String username, HttpServletResponse response) {
        Cookie tokenCookie = new Cookie(Consts.TOKEN, username);
        tokenCookie.setMaxAge(2 * 60 * 60);
        tokenCookie.setPath("/");
        response.addCookie(tokenCookie);
        return "login";
    }

    @PostMapping
    public String execPost(String username, HttpServletResponse response) {
        response.addCookie(new Cookie(Consts.TOKEN, username));
        return "index";
    }

}
