package controller.get;

import java.util.Map;

import controller.ControllerInter;

public class TestController implements ControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		System.out.println(paramMap);
		System.out.println("TestController");
		return "hello";
	}
	

}
