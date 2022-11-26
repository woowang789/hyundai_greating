package webControllerV2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllerInterface {

    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
