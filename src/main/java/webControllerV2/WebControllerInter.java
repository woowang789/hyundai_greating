package webControllerV2;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WebControllerInter {
	
	String process(HttpServletRequest request, HttpServletResponse response);
}
