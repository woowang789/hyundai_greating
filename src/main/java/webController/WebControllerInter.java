package webController;

import java.util.Map;

public interface WebControllerInter {
	
	String process(Map<String,String> paramMap,Map<String,Object> model);
}
