package webController.get;

import java.util.Map;

import webController.ControllerInter;

public class SignupController implements ControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		return "signup";
	}
	

}
