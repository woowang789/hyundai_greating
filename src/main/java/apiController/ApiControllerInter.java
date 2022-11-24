package apiController;

import java.util.Map;

import org.json.simple.parser.ParseException;



public interface ApiControllerInter {
	
	void process(String body, Map<String, Object> model) throws ParseException;
}
