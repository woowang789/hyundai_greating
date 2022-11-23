package webController.get;

import java.util.Map;

import webController.ControllerInter;

public class ProductDetailController implements ControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		return "product_detail";
	}
	

}
