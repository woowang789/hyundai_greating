package webControllerV2;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import dao.CartDAO;
import dao.OrderDAO;
import util.SessionUtil;
import vo.OrderProductInsertVO;

public class DoOrder implements ControllerInterface{
	private OrderDAO orderDao = OrderDAO.getInstance();
	private CartDAO cartDao = CartDAO.getInstance();
	private JSONParser parser = new JSONParser();
	
	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isDir = false;
		if(request.getParameter("isDir") != null) 
			isDir = request.getParameter("isDir").toString().equals("N")?
					false:true;
		
		
		String userId = SessionUtil.getUserId(request);
//		String name = request.getParameter("name");
		String email = request.getParameter("email_h")+
				"@"+request.getParameter("email_t");
		String rcvName = request.getParameter("rcv_name");
		String address = request.getParameter("rcv_addr1")+" "+
				request.getParameter("rcv_addr2");
		String jsonStr = URLDecoder.decode(request.getParameter("prods"),"UTF-8");
		List<OrderProductInsertVO> list = new ArrayList<>();
		try {
			JSONObject obj = (JSONObject) parser.parse(jsonStr);
			JSONArray arr = (JSONArray) obj.get("prods");
			for(int i =0;i<arr.size();i++) {
				JSONObject prod = (JSONObject) arr.get(i);
				OrderProductInsertVO vo = new OrderProductInsertVO();
				int optnId = Integer.parseInt(prod.get("optnId").toString());
				int prodId = Integer.parseInt(prod.get("prodId").toString());
				int qty = Integer.parseInt(prod.get("stock").toString());
				int price = Integer.parseInt(prod.get("price").toString());
				vo.setOptnId(optnId);
				vo.setProdId(prodId);
				vo.setQty(qty);
				vo.setPrice(price);
				list.add(vo);
			}
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date date = orderDao.insertOrder(userId, email, address, rcvName,list);
		if(!isDir) 
			cartDao.emptyCart(userId);
		return new MyView("href:/v1/orderComplete?date="+date.getTime());
	}
	

}
