package apiController.get;

import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import apiController.ApiControllerInter;

public class TestApi implements ApiControllerInter{
	private JSONParser parser = new JSONParser();

	@Override
	public void process(String body,Map<String, Object> model) throws ParseException{
		
		
		
	}
	
	

}
