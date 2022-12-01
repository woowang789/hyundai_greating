package webControllerV2;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import util.DateParser;
import util.SessionUtil;
import vo.OrderVO;


public class ShowOrderComplete implements Action{
	private OrderDAO orderDao = OrderDAO.getInstance();
	

	@Override
	public MyView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = SessionUtil.getUserId(request);
		long dataLong = Long.parseLong(request.getParameter("date"));
		OrderVO order = orderDao.getOrder(userId, new Date(dataLong));
		System.out.println(order.getReceiverName());
		System.out.println(order.getOrderProds().size()+"개의 품목");
		request.setAttribute("order", order);
		
		return new MyView("order_complete");
	}

}
