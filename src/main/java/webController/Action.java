package webController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author 왕종휘
 */ 

public interface Action {

    MyView execute(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException;
}
