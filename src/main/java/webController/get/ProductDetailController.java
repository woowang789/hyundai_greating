package webController.get;

import java.util.Map;

import webController.WebControllerInter;

public class ProductDetailController implements WebControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		return "product_detail";
	}
	

}
