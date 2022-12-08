package webController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.ProductVO;

/**
 * 
 * @author 왕종휘
 */ 

public class ShowBestProductList extends GetAction{
	private ProductDAO prodDao = ProductDAO.getInstance();

	
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return new MyView("best_product_list");
	}
	

}
