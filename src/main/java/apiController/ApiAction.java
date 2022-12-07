package apiController;

import java.util.Map;

import org.json.simple.parser.ParseException;



public interface ApiAction {
	
	void execute(String body, Map<String,String> paramMap,Map<String, Object> model) throws ParseException;
}
