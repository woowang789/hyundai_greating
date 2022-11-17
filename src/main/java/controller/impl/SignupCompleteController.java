package controller.impl;

import java.util.Map;

import controller.ControllerInter;

public class SignupCompleteController implements ControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {

		return "signup_complete";
	}
	
	

}
