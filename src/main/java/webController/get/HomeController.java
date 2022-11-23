package webController.get;

import java.util.Map;

import dao.TestDao;
import webController.ControllerInter;

public class HomeController implements ControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		TestDao dao = new TestDao();
		dao.listMembers();
		return "home";
	}
}
