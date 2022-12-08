package apiController.post;

import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import apiController.ApiAction;
import dao.CartDAO;

/**
 * 
 * @author 왕종휘
 */

public class RemoveCartProduct implements ApiAction{
	private CartDAO cartDao = CartDAO.getInstance();
	private JSONParser parser = new JSONParser();

	@Override
	public void execute(String body, Map<String, String> paramMap, Map<String, Object> model) throws ParseException {
		JSONObject json = (JSONObject) parser.parse(body);
		int optnId = 
				Integer.parseInt(json.get("optnId").toString());
		String userId = json.get("userId").toString();
		cartDao.removeCartProduct(userId, optnId);
	}
	
	

}
