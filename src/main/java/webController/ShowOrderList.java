package webController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import util.SessionUtil;
import vo.OrderProductVO;


public class ShowOrderList extends GetAction{
	private OrderDAO orderDao = OrderDAO.getInstance();

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = SessionUtil.getUserId(request);
		List<OrderProductVO> list = orderDao.getOrderList(userId);
		Map<Long, List<OrderProductVO>> map = new HashMap<>();
		for(OrderProductVO vo : list) {
			if(!map.containsKey(vo.getOrderDate().getTime()))
				map.put(vo.getOrderDate().getTime(),new ArrayList<>());
			map.get(vo.getOrderDate().getTime()).add(vo);
		}
		request.setAttribute("orders", map);
		return new MyView("order_list");
	}

}