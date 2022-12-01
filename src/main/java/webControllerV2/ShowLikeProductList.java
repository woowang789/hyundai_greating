package webControllerV2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InterestDAO;
import util.SessionUtil;
import vo.ProductVO;


public class ShowLikeProductList implements Action{
	private InterestDAO interestDao = InterestDAO.getInstance();
	

	@Override
	public MyView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = SessionUtil.getUserId(request).toString();
		List<ProductVO> list = interestDao.getInterestProductList(userId);
		request.setAttribute("prods", list);
		
		return new MyView("like_product_list");
	}

}
