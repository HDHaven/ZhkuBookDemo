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

@WebFilter(description = "�û�������ҳǰ��ȡ��Ҫ����Ϣ", urlPatterns = { "/index.jsp" })
public class InitIndex implements Filter {

    public InitIndex() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		// ��ȡ��������Լ���������
		UserService us = new UserService();
		req.getSession().setAttribute("NewUpload", us.getBookByLastDate(null));
		req.getSession().setAttribute("HotSale", us.getBookByHotSale(null));
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
