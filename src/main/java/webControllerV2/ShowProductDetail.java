package webControllerV2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InterestDAO;
import dao.ProductDAO;
import util.SessionUtil;
import vo.ProductDetailVO;

public class ShowProductDetail implements ControllerInterface{
	private ProductDAO productDao = ProductDAO.getInstance();
	private InterestDAO interDao = InterestDAO.getInstance();

	
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int prodId = Integer.parseInt(request.getParameter("prodId"));
		boolean isInterested = false;
		ProductDetailVO detail =  productDao.getProductDetail(prodId);
		
		String userId = SessionUtil.getUserId(request);
		if(userId != null)
			isInterested = interDao.exsistInterest(userId, prodId);
		request.setAttribute("detail", detail);
		request.setAttribute("isInterested", isInterested);
		
		return new MyView("product_detail");
	}

}
