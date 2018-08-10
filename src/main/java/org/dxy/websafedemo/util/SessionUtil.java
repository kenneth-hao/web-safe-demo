package org.dxy.websafedemo.util;

import javax.servlet.http.HttpServletRequest;

public final class SessionUtil {

    public static String getUsername(HttpServletRequest request) {
        return WebUtil.getCookieValue(request, Consts.TOKEN);
    }

}
