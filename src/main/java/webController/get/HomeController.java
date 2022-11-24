package webController.get;

import java.util.Map;

import dao.TestDao;
import webController.WebControllerInter;

public class HomeController implements WebControllerInter{

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
//		TestDao dao = new TestDao();
//		dao.listMembers();
		return "home";
	}
}
