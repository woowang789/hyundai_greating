package controller.impl;

import java.util.Map;

import controller.ControllerInter;

public class TestController implements ControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		
		return "hello";
	}
	

}
