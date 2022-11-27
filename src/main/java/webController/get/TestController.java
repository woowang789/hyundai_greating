package webController.get;

import java.util.Map;

import webController.WebControllerInter;

public class TestController implements WebControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		System.out.println(paramMap);
		System.out.println("TestController");
		return "hello";
	}
	

}
