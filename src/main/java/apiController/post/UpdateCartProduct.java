package apiController.post;

import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import apiController.ApiControllerInter;
import dao.CartDAO;

public class UpdateCartProduct implements ApiControllerInter{
	private CartDAO cartDao = CartDAO.getInstance();
	private JSONParser parser = new JSONParser();

	@Override
	public void process(String body, Map<String, String> paramMap, Map<String, Object> model) throws ParseException {
		JSONObject json = (JSONObject) parser.parse(body);
		int optnId = 
				Integer.parseInt(json.get("optnId").toString());
		int stock = Integer.parseInt(json.get("stock").toString());
		String userId = json.get("userId").toString();
		
		cartDao.updateCartProduct(userId, optnId, stock);
		
		
		
	}
	
	

}
