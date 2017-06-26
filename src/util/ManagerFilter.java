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

@WebFilter(description = "�жϷ������Ƿ��е��Ȩ��", urlPatterns = { "/manager/*" })
public class ManagerFilter implements Filter {

    public ManagerFilter() {
    }

	public void destroy() {
	}

	/**
	 * �жϷ������Ƿ��е��Ȩ��
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		if(req.getSession().getAttribute("ManagerUser") != null) {
			// �Ϸ����ʣ�����
			chain.doFilter(request, response);
		} else {
			// ���Ϸ�����ʾ���󣬷���
			resp.getWriter().println("<script>alert('ҵ���쳣��')</script>");
			resp.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
