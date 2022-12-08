package filter;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author 왕종휘
 */

@WebFilter("/v1/*")
public class WebAuthFilter implements Filter{
	private Set<String> authUrls;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		authUrls = new HashSet<>();
		authUrls.add("/v1/signupComplete");
		authUrls.add("/v1/order");
		authUrls.add("/v1/cart");
		authUrls.add("/v1/orderList");
		authUrls.add("/v1/orderComplete");
		authUrls.add("/v1/likeProductList");
		authUrls.add("/v1/order.do");
		authUrls.add("/v1/viewProductList");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String requestUri = req.getRequestURI();
		if(authUrls.contains(requestUri)) {
			String redirect = requestUri +"?"+ req.getParameterMap().entrySet().stream()
			.map(i-> i.getKey()+"="+i.getValue()[0]).collect(Collectors.joining("&"));
			HttpSession session = req.getSession(false);
			if(session == null || session.getAttribute("user") == null) {
				HttpServletResponse res = (HttpServletResponse) response;
				
				res.sendRedirect("/v1/signin?redirect="+URLEncoder.encode(redirect, "UTF-8"));
				return;
			}
		}
		chain.doFilter(request, response);
	}
	
}
