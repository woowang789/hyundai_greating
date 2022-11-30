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

import com.fasterxml.jackson.databind.ObjectMapper;

import apiController.get.GetBestProductList;
import apiController.get.GetProductList;
import apiController.post.CheckId;
import apiController.post.InsertComment;
import apiController.post.RemoveCartProduct;
import apiController.post.ToggleInterest;
import apiController.post.UpdateCartProduct;



@WebServlet("/api/*")
public class ApiFrontController extends HttpServlet {
	private ObjectMapper mapper = new ObjectMapper();
	private Map<String, ApiControllerInter> controllerMap = new ConcurrentHashMap<>();
	
	public ApiFrontController() {
		controllerMap.put("/api/productList", new GetProductList());
		controllerMap.put("/api/bestProductList", new GetBestProductList());
		
		controllerMap.put("/api/updateCart", new UpdateCartProduct());
		controllerMap.put("/api/removeCart", new RemoveCartProduct());
		controllerMap.put("/api/toggleInterest", new ToggleInterest());
		controllerMap.put("/api/checkId", new CheckId());
		
		controllerMap.put("/api/insertComment", new InsertComment());
	}



	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("application/json;charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		Map<String,String> paramMap = createParamMap(request);
		Map<String, Object> model = new HashMap<>();
		
		ApiControllerInter controllerInter = controllerMap.get(request.getRequestURI());
		
		
		if(controllerInter == null) {
			model.put("code", 404);
			model.put("msg", "not found");
		}else {
			
			String bodyJson = getBodyJson(request);
			
			try {
				controllerInter.process(bodyJson,paramMap,model);
				model.put("code", 200);
				model.put("msg","succes");
			} catch (Exception e) {
				model.put("code", 405);
				model.put("msg", "잘못된 파라미터");
				e.printStackTrace();
			}
		}
		writer.print(mapper.writeValueAsString(model));
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
    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
