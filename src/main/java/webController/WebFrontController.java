package webController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webController.get.BestProductListController;
import webController.get.CartController;
import webController.get.HomeController;
import webController.get.LikeProductListController;
import webController.get.OrderCompleteController;
import webController.get.OrderController;
import webController.get.OrderListController;
import webController.get.ProductDetailController;
import webController.get.ProductListController;
import webController.get.SigninController;
import webController.get.SignupCompleteController;
import webController.get.SignupController;
import webController.get.TestController;
import webController.get.ViewProductListController;

@WebServlet(urlPatterns = "/v1/*")
public class WebFrontController extends HttpServlet {

    private Map<String, WebControllerInter> controllerMap = new ConcurrentHashMap<>();

    public WebFrontController() {
    	System.out.println("FrontController 생성자");
        controllerMap.put("/v1/test", new TestController());
        
        controllerMap.put("/v1/", new HomeController());
        controllerMap.put("/v1/signin",new SigninController());
        controllerMap.put("/v1/signup", new SignupController());
        
        //임시 테스트용, signup 완료 후 redirect로만 접근 가능해야 함
        controllerMap.put("/v1/signupComplete", new SignupCompleteController());
        controllerMap.put("/v1/productList", new ProductListController());
        controllerMap.put("/v1/productDetail", new ProductDetailController());
        controllerMap.put("/v1/bestProductList",new BestProductListController());
        controllerMap.put("/v1/order", new OrderController());
        controllerMap.put("/v1/cart", new CartController());
        controllerMap.put("/v1/orderList", new OrderListController());
        
      //임시 테스트용, order 완료 후 redirect로만 접근 가능해야 함
        controllerMap.put("/v1/orderComplete", new OrderCompleteController());
        controllerMap.put("/v1/likeProductList", new LikeProductListController());
        controllerMap.put("/v1/viewProductList", new ViewProductListController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8");
    	
        String requestURI = request.getRequestURI();

        WebControllerInter controller = controllerMap.get(requestURI);
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