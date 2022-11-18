package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.impl.BestItemListController;
import controller.impl.HomeController;
import controller.impl.ItemDetailController;
import controller.impl.ItemListController;
import controller.impl.OrderCompleteController;
import controller.impl.OrderController;
import controller.impl.OrderListController;
import controller.impl.ShoppingcartController;
import controller.impl.SignInController;
import controller.impl.SignupCompleteController;
import controller.impl.SignupController;
import controller.impl.TestController;

@WebServlet(urlPatterns = "/v1/*")
public class FrontController extends HttpServlet {

    private Map<String, ControllerInter> controllerMap = new ConcurrentHashMap<>();

    public FrontController() {
    	System.out.println("FrontController 생성자");
        controllerMap.put("/v1/test", new TestController());
        
        controllerMap.put("/v1/", new HomeController());
        controllerMap.put("/v1/signin",new SignInController());
        controllerMap.put("/v1/signup", new SignupController());
        //임시 테스트용, signup 완료 후 redirect로만 접근 가능해야 함
        controllerMap.put("/v1/signupComplete", new SignupCompleteController());  
        controllerMap.put("/v1/itemList", new ItemListController());
        controllerMap.put("/v1/itemDetail", new ItemDetailController());
        controllerMap.put("/v1/bestItemList",new BestItemListController());
        controllerMap.put("/v1/order", new OrderController());
        controllerMap.put("/v1/shoppingcart", new ShoppingcartController());
        controllerMap.put("/v1/orderList", new OrderListController());
      //임시 테스트용, order 완료 후 redirect로만 접근 가능해야 함
        controllerMap.put("/v1/orderComplete", new OrderCompleteController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8");
    	
        String requestURI = request.getRequestURI();

        ControllerInter controller = controllerMap.get(requestURI);
        if ( controller == null) {
        	System.out.println("NOT FOUND "+requestURI);
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>(); 

        String viewName = controller.process(paramMap, model);

        MyView view = new MyView(viewName);
        view.render(model, request, response);
    }


    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}