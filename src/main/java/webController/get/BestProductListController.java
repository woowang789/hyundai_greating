package webController.get;

import java.util.Map;

import webController.WebControllerInter;

public class BestProductListController implements WebControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		return "best_product_list";
	}
	

}
