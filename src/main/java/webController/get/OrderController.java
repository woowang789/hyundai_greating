package webController.get;

import java.util.Map;

import webController.WebControllerInter;

public class OrderController implements WebControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		return "order";
	}
	

}
