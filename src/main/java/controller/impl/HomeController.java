package controller.impl;

import java.util.Map;

import controller.ControllerInter;
import dao.TestDAO;

public class HomeController implements ControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		TestDAO dao = new TestDAO();
		dao.listMembers();
		return "home";
	}
	
	

}
