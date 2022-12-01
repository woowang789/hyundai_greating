package webControllerV2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.ProductVO;


public class ShowBestProductList implements Action{
	private ProductDAO prodDao = ProductDAO.getInstance();

	
	@Override
	public MyView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return new MyView("best_product_list");
	}
	

}
