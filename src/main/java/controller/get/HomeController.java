package controller.get;

import java.util.Map;

import controller.ControllerInter;
import dao.TestDao;

public class HomeController implements ControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		TestDao dao = new TestDao();
		dao.listMembers();
		return "home";
	}
}
