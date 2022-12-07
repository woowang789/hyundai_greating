package apiController.post;

import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import apiController.ApiAction;
import dao.UserDAO;
import vo.UserVO;

public class CheckId implements ApiAction{
	private JSONParser parser = new JSONParser();
	private UserDAO userDao = UserDAO.getInstance();

	@Override
	public void execute(String body, Map<String, String> paramMap, Map<String, Object> model) throws ParseException {
		JSONObject json = (JSONObject) parser.parse(body);
		String id = json.get("userId").toString();
		UserVO findUser = userDao.getUserById(id);
		model.put("flag", findUser==null);
	}
	
	

}
