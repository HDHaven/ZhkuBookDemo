package userservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet(description = "�����û���¼", urlPatterns = { "/DoLogin" })
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �����û���¼
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		// �����¼
		UserService us = new UserService();
		int userType = us.login(userName, password);
		if(userType == 1) {
			// ��Ա������Ȩ��
			request.getSession().setAttribute("LoginUser", userName);
			request.getSession().setAttribute("UserAddr", us.getAddr(userName));
			if(us.isManager(userName)) {
				// �����Լ��ĵ���
				request.getSession().setAttribute("ManagerUser", userName);
			}
			// ��¼�ɹ�����ת����ҳ
			response.sendRedirect(request.getContextPath() +"/index.jsp");
		} else if(userType == 2) {
			// ����Ա������Ȩ�ޣ���ת��������ҳ
			request.getSession().setAttribute("AdminUser", userName);
			response.sendRedirect(request.getContextPath() +"/admin/index.jsp");
		} else {
			// ��¼ʧ�ܣ�������һҳ
			response.getWriter().println("<script>alert('�û��������벻ƥ�䣡')</script>");
			response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/login.jsp");
		}
	}

}
