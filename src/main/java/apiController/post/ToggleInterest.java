package apiController.post;

import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import apiController.ApiControllerInter;
import dao.InterestDAO;

public class ToggleInterest implements ApiControllerInter {
	private InterestDAO interestDao = InterestDAO.getInstance();
	private JSONParser parser = new JSONParser();

	@Override
	public void process(String body, Map<String, String> paramMap, Map<String, Object> model) throws ParseException {
		JSONObject json = (JSONObject) parser.parse(body);
		int prodId = 
				Integer.parseInt(json.get("prodId").toString());
		String userId = json.get("userId").toString();
		interestDao.toggleInterest(userId, prodId);
	}

}
