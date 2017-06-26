package util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import service.UserService;

@WebFilter(description = "用户进入首页前获取必要的信息", urlPatterns = { "/index.jsp" })
public class InitIndex implements Filter {

    public InitIndex() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		// 获取最近上新以及热卖的书
		UserService us = new UserService();
		req.getSession().setAttribute("NewUpload", us.getBookByLastDate(null));
		req.getSession().setAttribute("HotSale", us.getBookByHotSale(null));
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
