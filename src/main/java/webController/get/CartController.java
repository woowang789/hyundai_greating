package webController.get;

import java.util.Map;

import webController.ControllerInter;

public class CartController implements ControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		return "cart";
	}
	
	
	

}