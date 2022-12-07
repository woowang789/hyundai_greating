package webController;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyView {
    private String viewName;

    public MyView(String viewName) {
        this.viewName = viewName;
    }
    
    public void render(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    	if(viewName.startsWith("href:")) {
        	response.sendRedirect(viewName.substring("href:".length()));
        	return;
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(getViewPath(viewName));
        dispatcher.forward(request, response);
    }
    
    private String getViewPath(String viewName) {
    	return "/WEB-INF/jsp/" + viewName + ".jsp";
    }
}
