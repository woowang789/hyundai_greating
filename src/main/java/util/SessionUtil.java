package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.UserVO;

public class SessionUtil {
	public static String getUserId(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("users") == null)
			return null;
		UserVO user = (UserVO) session.getAttribute("users");
		return user.getName();
	}
}
