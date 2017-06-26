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

@WebFilter(description = "���ʹ���ҳ��ʱ�ж��Ƿ��й���ԱȨ��", urlPatterns = { "/admin/*" })
public class AdminFilter implements Filter {

    public AdminFilter() {
    }

	public void destroy() {
	}

	/**
	 * ����ԱȨ����֤
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		if(req.getSession().getAttribute("AdminUser") != null) {
			// �ǹ���Ա�û��������
			chain.doFilter(request, response);
		} else {
			// ������ʾ���󣬷�����һҳ
			resp.getWriter().println("<script>alert('���ʳ����ˣ�')</script>");
			resp.setHeader("Refresh", "1; url=javascript:history.go(-1);");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
