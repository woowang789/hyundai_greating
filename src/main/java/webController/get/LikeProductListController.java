package webController.get;

import java.util.Map;

import webController.WebControllerInter;

public class LikeProductListController implements WebControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		return "like_product_list";
	}
	

}
