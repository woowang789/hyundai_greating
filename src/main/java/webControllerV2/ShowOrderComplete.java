package webControllerV2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import util.DateParser;
import util.SessionUtil;
import vo.OrderVO;


public class ShowOrderComplete implements ControllerInterface{
	private OrderDAO orderDao = OrderDAO.getInstance();
	

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = SessionUtil.getUserId(request);
		String date = "2022-11-24 00:00:00";
		OrderVO order = orderDao.getOrder("angz", DateParser.strToDateWithTime(date));
		System.out.println(order.getReceiverName());
		System.out.println(order.getOrderProds().size()+"개의 품목");
		request.setAttribute("order", order);
		
		return new MyView("order_complete");
	}

}
