package webControllerV2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InterestDAO;
import dao.ProductDAO;
import util.CookieUtil;
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
	
		// 쿠키 셋팅
		setCookie(request,response, prodId);
		
		
		String userId = SessionUtil.getUserId(request);
		if(userId != null)
			isInterested = interDao.exsistInterest(userId, prodId);
		request.setAttribute("detail", detail);
		request.setAttribute("isInterested", isInterested);
		
		return new MyView("product_detail");
	}
	
	private void setCookie(HttpServletRequest request, HttpServletResponse response,int prodId) {
		String value = CookieUtil.getCookie(request, response, "viewProds");
		List<String> list = new ArrayList<>();
		if(value != null) {
			list = Arrays
					.stream(value.split("/")).collect(Collectors.toList());
			if(list.contains(prodId+"")) 
				list.remove(prodId+"");
		}
		list.add(prodId+"");
		
		Cookie cookie = new Cookie("viewProds", list.stream().collect(Collectors.joining("/")));
		cookie.setMaxAge(60*60*24*7);
		response.addCookie(cookie);
	}

}
