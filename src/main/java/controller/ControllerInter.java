package controller;

import java.util.Map;

public interface ControllerInter {
	
	String process(Map<String,String> paramMap,Map<String,Object> model);
}
