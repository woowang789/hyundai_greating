package apiController.post;

import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import apiController.ApiControllerInter;
import dao.CartDAO;

public class InsertCartProduct implements ApiControllerInter{
	private CartDAO cartDao = CartDAO.getInstance();
	private JSONParser parser = new JSONParser();
	
	@Override
	public void process(String body, Map<String, String> paramMap, Map<String, Object> model) throws ParseException {
		JSONObject json = (JSONObject) parser.parse(body);
		int optnId = 
				Integer.parseInt(json.get("optnId").toString());
		int stock = Integer.parseInt(json.get("stock").toString());
		String userId = json.get("userId").toString();
		// todo : 장바구니 insert update 하나의 프로시저로 묶기
		// & 관심 상품 추가/ 제거 마찬가지로
		
		
	}
 
}
