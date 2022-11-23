package controller.get;

import java.util.Map;

import controller.ControllerInter;

public class ViewProductListController implements ControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		return "view_product_list";
	}
	
	

}
