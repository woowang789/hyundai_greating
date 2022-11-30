package webControllerV2;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/v1/*")
public class WebFrontController extends HttpServlet {

    private Map<String, ControllerInterface> controllerMap = new ConcurrentHashMap<>();

    public WebFrontController() {
        
        controllerMap.put("/v1/", new ShowHome());
        controllerMap.put("/v1/signin",new ShowSignin());
        controllerMap.put("/v1/signup", new ShowSignup());
        
        //임시 테스트용, signup 완료 후 redirect로만 접근 가능해야 함
        controllerMap.put("/v1/signupComplete", new ShowSignupComplete());
        controllerMap.put("/v1/productList", new ShowProductList());
        controllerMap.put("/v1/productDetail", new ShowProductDetail());
        controllerMap.put("/v1/bestProductList",new ShowBestProductList());
        controllerMap.put("/v1/order", new ShowOrder());
        controllerMap.put("/v1/cart", new ShowCart());
        controllerMap.put("/v1/orderList", new ShowOrderList());
        
      //임시 테스트용, order 완료 후 redirect로만 접근 가능해야 함
        controllerMap.put("/v1/orderComplete", new ShowOrderComplete());
        controllerMap.put("/v1/likeProductList", new ShowLikeProductList());
        controllerMap.put("/v1/viewProductList", new ShowViewProductList());
        controllerMap.put("/v1/searchProductList", new ShowSearchProductList());
    
        controllerMap.put("/v1/signin.do",new DoSignin());
        controllerMap.put("/v1/signup.do", new DoSignup());
        controllerMap.put("/v1/signout", new DoSignout());
        controllerMap.put("/v1/order.do", new DoOrder());
    }

    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8");
    	
        String requestURI = request.getRequestURI();

        ControllerInterface controller = controllerMap.get(requestURI);
        if ( controller == null) {
        	System.out.println("NOT FOUND "+requestURI);
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView view = controller.process(request, response);
        view.render(request, response);
    }
}