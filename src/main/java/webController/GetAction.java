package webController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author 왕종휘
 */ 

public abstract class GetAction implements Action{

	@Override
	public MyView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(!request.getMethod().equals("GET")) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
		return process(request, response);
	}
	
	
	abstract MyView process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
}
