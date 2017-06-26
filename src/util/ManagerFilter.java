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

@WebFilter(description = "判断访问者是否有店家权限", urlPatterns = { "/manager/*" })
public class ManagerFilter implements Filter {

    public ManagerFilter() {
    }

	public void destroy() {
	}

	/**
	 * 判断访问者是否有店家权限
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		if(req.getSession().getAttribute("ManagerUser") != null) {
			// 合法访问，放行
			chain.doFilter(request, response);
		} else {
			// 不合法，提示错误，返回
			resp.getWriter().println("<script>alert('业务异常！')</script>");
			resp.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
