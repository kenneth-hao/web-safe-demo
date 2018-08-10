package org.dxy.websafedemo.interceptor;

import com.google.common.collect.Sets;
import org.dxy.websafedemo.util.Consts;
import org.dxy.websafedemo.util.WebUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

public class LoginInterceptor implements HandlerInterceptor {

    private Set<String> NON_LOGIN_REQUIRE_URLS = Sets.newHashSet(Consts.URL.LOGIN, Consts.URL.LOGOUT, Consts.URL.ERROR);

    private boolean loginRequire(HttpServletRequest request) {
        boolean loginRequire = false;
        if (!NON_LOGIN_REQUIRE_URLS.contains(request.getRequestURI())) {
            String token = WebUtil.getCookieValue(request, Consts.TOKEN);
            if (StringUtils.isEmpty(token)) {
                loginRequire = true;
            }
        }
        return loginRequire;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (loginRequire(request)) {
            response.sendRedirect(Consts.URL.LOGIN);
            return false;
        }
        return true;
    }
}
