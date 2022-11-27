package webControllerV2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoSignup implements ControllerInterface{

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getAttribute("name").toString();
		return new MyView("href:/v1/signupComplete");
	}
	

}
