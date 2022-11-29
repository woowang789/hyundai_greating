package webControllerV2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import dao.ProductDAO;
import vo.OrderProductBeforeVO;


public class ShowOrder implements ControllerInterface{
	private ProductDAO prodDao = ProductDAO.getInstance();
	private JSONParser parser = new JSONParser();
	

	@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String prodsStr = request.getParameter("prods");
		List<OrderProductBeforeVO> list = new ArrayList<>();
		try {
			
			JSONObject obj = (JSONObject) parser.parse(prodsStr);
			JSONArray prods = (JSONArray) obj.get("prods");
			for(int i =0;i<prods.size();i++) {
				JSONObject o = (JSONObject) parser.parse(prods.get(i).toString());
				int optnId = Integer.parseInt(o.get("optnId").toString());
				int qty = Integer.parseInt(o.get("qty").toString());
				
				OrderProductBeforeVO op = prodDao.getOrderProduct(optnId);
				System.out.println(op.getOptnName()+" "+op.getStock());
				if(op.getStock() < qty) 
					throw new RuntimeException("재고가 부족합니다.");
				op.setStock(qty);
				list.add(op);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("prods", list);

		return new MyView("order");
	}

}
