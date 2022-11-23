package controller.get;

import java.util.Map;

import controller.ControllerInter;

public class BestProductListController implements ControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		return "best_product_list";
	}
	

}
