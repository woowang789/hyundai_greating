package webController.get;

import java.util.Map;

import webController.ControllerInter;

public class LikeProductListController implements ControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		return "like_product_list";
	}
	

}
