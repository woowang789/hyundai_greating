package webController;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import util.DateParser;
import vo.UserVO;

public class DoSignup extends PostAction{
	private UserDAO userDao = UserDAO.getInstance();
	
	
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name").toString();
		String id = request.getParameter("id").toString();
		String pw = request.getParameter("pw").toString();
		String email = request.getParameter("e_h")
				+"@"+
				request.getParameter("e_t");
		String birth = request.getParameter("birth").toString();
		Date birthDate = DateParser.strToDate(birth);
		String gender = request.getParameter("gender").toString();
		userDao.joinMember(id, name, email, birthDate, gender,pw);
		
		UserVO newUser = userDao.getUserById(id);
		if(request.getSession(false) != null) 
			request.getSession(false).invalidate();
		System.out.println(newUser.getId());
		HttpSession session = request.getSession();
		session.setAttribute("user", newUser);

		return new MyView("href:/v1/signupComplete");
	}
}
