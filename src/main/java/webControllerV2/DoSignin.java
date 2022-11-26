package webControllerV2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import vo.UserVO;

public class DoSignin implements ControllerInterface{
	private UserDAO userDao = UserDAO.getInstance();
	

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		UserVO user = userDao.getUserById(id);
		if(user == null) return new MyView("href:/v1/signin?error=notfound");
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		return new MyView("href:/v1/");
	}

	
	
}