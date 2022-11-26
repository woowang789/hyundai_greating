package webController.post;

import java.util.Map;

import dao.UserDAO;
import vo.UserVO;
import webController.WebControllerInter;

public class SigninDo implements WebControllerInter{
	private UserDAO userDao = UserDAO.getInstance();

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		UserVO user = userDao.getUserById(paramMap.get("id"));
		if(user == null) 
			return "href:/v1/signin?error=notfound";
		// 에러 메시지 띄우기 , 세션 만들어 넣기
		
		model.put("user",user);
		return "href:/v1/";
	}
	
	
	
}
