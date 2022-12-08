package webController;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import util.SessionUtil;
import vo.OrderVO;

/**
 * 
 * @author 이세아
 */

public class ShowOrderComplete extends GetAction{
	private OrderDAO orderDao = OrderDAO.getInstance();
	

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = SessionUtil.getUserId(request);
		long dataLong = Long.parseLong(request.getParameter("date"));
		OrderVO order = orderDao.getOrder(userId, new Date(dataLong));
		request.setAttribute("order", order);
		
		return new MyView("order_complete");
	}

}
