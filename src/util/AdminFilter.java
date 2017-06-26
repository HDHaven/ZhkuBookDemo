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

@WebFilter(description = "访问管理页面时判断是否有管理员权限", urlPatterns = { "/admin/*" })
public class AdminFilter implements Filter {

    public AdminFilter() {
    }

	public void destroy() {
	}

	/**
	 * 管理员权限验证
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		if(req.getSession().getAttribute("AdminUser") != null) {
			// 是管理员用户，则放行
			chain.doFilter(request, response);
		} else {
			// 否则提示错误，返回上一页
			resp.getWriter().println("<script>alert('访问出错了！')</script>");
			resp.setHeader("Refresh", "1; url=javascript:history.go(-1);");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
