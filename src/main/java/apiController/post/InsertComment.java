package apiController.post;

import java.sql.Date;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import apiController.ApiControllerInter;
import dao.CommentDAO;

public class InsertComment implements ApiControllerInter{
	private JSONParser parser = new JSONParser();
	private CommentDAO commentDAO = CommentDAO.getInstance();
	@Override
	public void process(String body, Map<String, String> paramMap, Map<String, Object> model) throws ParseException {
		JSONObject json = (JSONObject) parser.parse(body);
		String title = json.get("title").toString();
		String text = json.get("text").toString();
		
		int prodId = Integer.parseInt(json.get("prodId").toString());
		String userId = json.get("userId").toString();
		int optnId = Integer.parseInt(json.get("optnId").toString());
		Date orderDate = new Date(Long.parseLong(json.get("orderDateLong").toString()));
		commentDAO.insertComment(userId, prodId, optnId, orderDate, title, text);
	}
	
	

}
