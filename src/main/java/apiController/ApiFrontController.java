package apiController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

import apiController.get.GetProductList;
import apiController.get.TestApi;



@WebServlet("/api/*")
public class ApiFrontController extends HttpServlet {
	private ObjectMapper mapper = new ObjectMapper();
	private Map<String, ApiControllerInter> controllerMap = new ConcurrentHashMap<>();
	
	public ApiFrontController() {
		controllerMap.put("/api/test", new TestApi());
		
		controllerMap.put("/api/productList", new GetProductList());
	}



	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("application/json;charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		Map<String, Object> map = new HashMap<>();
		
		ApiControllerInter controllerInter = controllerMap.get(request.getRequestURI());
		
		if(controllerInter == null) {
			map.put("code", 404);
			map.put("msg", "not found");
			writer.print(mapper.writeValueAsString(map));
			return;
		}
		String bodyJson = getBodyJson(request);
		
		try {
			controllerInter.process(bodyJson,map);
		} catch (Exception e) {
			map.put("code", 405);
			map.put("msg", "잘못된 파라미터");
			e.printStackTrace();
			
			writer.print(mapper.writeValueAsString(map));
			return;
		}
		map.put("code", 200);
		map.put("msg","succes");
		writer.print(mapper.writeValueAsString(map));
	}
	
	private String getBodyJson(HttpServletRequest request) {
		String bodyJson = "";
        
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader br = null;
		        
		try {
			 String line = "";
		     InputStream inputStream = request.getInputStream();
		     if (inputStream != null) {
		    	 br = new BufferedReader(new InputStreamReader(inputStream));
		         while ((line = br.readLine()) != null) {
		        	 stringBuilder.append(line);
		         }
		     }else {
		         System.out.println("body 없음");
		     }
		 } catch (IOException e) {
		     e.printStackTrace();
		 } 
		bodyJson = stringBuilder.toString();
		return bodyJson;
	}
}
