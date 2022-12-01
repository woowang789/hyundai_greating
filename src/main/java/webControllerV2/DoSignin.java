package webControllerV2;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import util.SHA256;
import vo.UserVO;

public class DoSignin extends PostAction{
	private UserDAO userDao = UserDAO.getInstance();
	

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		UserVO user = userDao.getUserById(id);
		if(user == null || !user.getEncrypPw().equals(SHA256.encodeSha256(pwd))) {
			return new MyView("href:/v1/signin?error=notfound");
		}
		 
		if(request.getSession(false) != null) 
			request.getSession(false).invalidate();
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		if(request.getParameter("redirect") != null) {
			String tmp[] = request.getParameter("redirect").split("\\?");
			if(tmp.length == 1) return new MyView("href:"+tmp[0]);
			String baseUrl = tmp[0]+"?";
			String[] token = tmp[1].split("&");
			for(int i =0;i<token.length;i++) {
				String[] t = token[i].split("=");
				baseUrl += t[0]+"="+URLEncoder.encode(t[1],"UTF-8");
				if(i < token.length -1) 
					baseUrl+= "&";				
			}
			return new MyView("href:"+baseUrl);
			
		}
		return new MyView("href:/v1/");
	}
}
