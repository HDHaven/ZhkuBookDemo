package userservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet(description = "�����û�ע��", urlPatterns = { "/Register" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �����û�ע��
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		// ע��
		UserService us = new UserService();
		int recNo = us.register(userName, password);
		if(recNo == 2) {
			// ע��ɹ�������Ȩ�ޣ���ת����ҳ
			request.getSession().setAttribute("LoginUser", userName);
			response.sendRedirect(request.getContextPath() +"/index.jsp");
		} else {
			// ע��ʧ�ܣ���ʾ������Ϣ��������һҳ��
			String msg = "ҵ���쳣��ע��ʧ�ܣ�";
			if(recNo == 1)
				msg = "�û����Ѵ��ڿ�";
			response.getWriter().println("<script>alert('"+ msg +"')</script>");
			response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/register.jsp");
		}
	}

}
