package org.dxy.websafedemo.util;

import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class WebUtil {

    public static final String getCookieValue(HttpServletRequest request, String name) {
        Cookie cookie = WebUtils.getCookie(request, name);
        return cookie == null ? "" : cookie.getValue();
    }

    /**
     *
     * @param response
     * @param name
     * @param value
     * @param expires 过期时间，单位: sec
     */
    public static final void setCookie(HttpServletResponse response, String name, String value, int expires) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(expires);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static final void removeCookie(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name, "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
