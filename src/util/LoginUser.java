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
import javax.servlet.http.HttpServletResponse;

@WebFilter(description = "用户权限验证", urlPatterns = { "/user/*" })
public class LoginUser implements Filter {

    public LoginUser() {
    }

	public void destroy() {
	}

	/**
	 * 用户权限验证
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		if(req.getSession().getAttribute("LoginUser") != null) {
			// 应登录用户
			chain.doFilter(request, response);
		} else {
			// 非法访问
			resp.getWriter().println("<script>alert('登录才能访问哦')</script>");
			resp.setHeader("Refresh", "1; url="+ req.getContextPath() +"/login.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
