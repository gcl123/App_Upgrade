package com.tt.javaserver.web.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;

/**
 * Created by feng on 3/30/16.
 */
public class CookieManager {

    public static Cookie format(String name, String value, int expired) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(expired);
        return cookie;
    }

    public static String parse(String name, Cookie[] cookies) {
        if (StringUtils.isBlank(name) || null == cookies || 0 == cookies
                .length) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (null != cookie && StringUtils.equalsIgnoreCase(name, cookie
                    .getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }

}
