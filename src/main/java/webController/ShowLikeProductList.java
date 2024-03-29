package webController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InterestDAO;
import util.SessionUtil;
import vo.ProductVO;

/**
 * 
 * @author 왕종휘
 */ 

public class ShowLikeProductList extends GetAction{
	private InterestDAO interestDao = InterestDAO.getInstance();
	

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = SessionUtil.getUserId(request).toString();
		List<ProductVO> list = interestDao.getInterestProductList(userId);
		request.setAttribute("prods", list);
		
		return new MyView("like_product_list");
	}

}
