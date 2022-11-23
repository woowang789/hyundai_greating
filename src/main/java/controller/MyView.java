package controller;

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
    
    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modelToRequestAttribute(model, request);
        
        if(viewName.startsWith("href:")) {
        	response.sendRedirect(viewName.substring("href:".length()));
        	return;
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(getViewPath(viewName));
        dispatcher.forward(request, response);
    }

    private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        model.forEach((key, value) -> request.setAttribute(key, value));
    }
    
    private String getViewPath(String viewName) {
    	return "/WEB-INF/jsp/" + viewName + ".jsp";
    }
   
}
