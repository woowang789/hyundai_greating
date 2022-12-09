package webController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author 왕종휘
 */ 

public class ShowSignin extends GetAction {

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("redirect") != null) {
			request.setAttribute("redirect", request.getParameter("redirect").replaceAll("\"","'"));
		}
		return new MyView("signin");
	}

}
