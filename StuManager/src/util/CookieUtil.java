package util;

import javax.servlet.http.Cookie;

/**
 * Created by kindleheart happily.
 */
public class CookieUtil {
    public static Cookie findCookie(Cookie[] cookies, String name) {
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
