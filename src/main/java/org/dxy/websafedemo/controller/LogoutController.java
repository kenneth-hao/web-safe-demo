package org.dxy.websafedemo.controller;

import org.dxy.websafedemo.util.Consts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(Consts.URL.LOGOUT)
public class LogoutController {

    @RequestMapping
    public String exec(HttpServletResponse response) {
        Cookie tokenCookie = new Cookie(Consts.TOKEN, "");
        tokenCookie.setMaxAge(0);
        tokenCookie.setPath("/");
        response.addCookie(tokenCookie);
        return "/login";
    }

}
