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
 * Servlet implementation class ImgController
 */
@WebServlet("/img111/*")
public class ImgController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		
		byte[] image = IOUtils.toByteArray(new FileInputStream(new File("/Users/wangjh789/Workspace/hyundai_greating/imgRepository/test-img.jpeg")));
		response.getOutputStream().write(image);
	}
}
