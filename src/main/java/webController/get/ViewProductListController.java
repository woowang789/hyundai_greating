package webController.get;

import java.util.Map;

import webController.ControllerInter;

public class ViewProductListController implements ControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		return "view_product_list";
	}
	
	

}
