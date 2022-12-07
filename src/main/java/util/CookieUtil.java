package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	public static String getCookie(HttpServletRequest request, 
			HttpServletResponse response, String cookieId) {
		for(Cookie c : request.getCookies()) {
			if(c.getName().equals(cookieId)) {
				return c.getValue();
			}
		}
		return null;
	}
}
