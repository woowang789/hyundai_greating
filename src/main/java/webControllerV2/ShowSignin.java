package webControllerV2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowSignin implements ControllerInterface{
	
	

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("redirect") != null) {
			request.setAttribute("redirect",request.getParameter("redirect"));
		}
		return new MyView("signin");
	}

	
}
