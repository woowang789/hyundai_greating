package ImgController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * 
 * @author 왕종휘
 */

@WebServlet("/image/*")
public class ImgController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		String uri = request.getRequestURI();
		String path = uri.substring("/image/".length()-1,uri.length());
		String filePath = "C:/Users/codea/git/hyundai_greating/imgRepository";
		filePath += path;
		byte[] image = IOUtils.toByteArray(new FileInputStream(new File(filePath)));
		response.getOutputStream().write(image);
	}
}