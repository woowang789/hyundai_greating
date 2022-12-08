package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.UserVO;

/**
 * 
 * @author 왕종휘
 */ 

public class SessionUtil {
	public static String getUserId(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("user") == null)
			return null;
		UserVO user = (UserVO) session.getAttribute("user");
		return user.getId();
	}
}
