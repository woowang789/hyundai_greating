package webControllerV2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import util.SessionUtil;
import vo.CartProductVO;


public class ShowCart extends GetAction{
	private CartDAO cartDao = CartDAO.getInstance();
	

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userId = SessionUtil.getUserId(request);
		List<CartProductVO> list = cartDao.getCartProductList(userId);
		
		request.setAttribute("prods", list);
		return new MyView("cart");
	}
}
