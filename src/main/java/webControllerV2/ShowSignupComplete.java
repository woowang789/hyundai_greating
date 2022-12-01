package webControllerV2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowSignupComplete implements Action{

	@Override
	public MyView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return new MyView("signup_complete");
	}
	

}
