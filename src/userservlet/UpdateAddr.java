package userservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import service.UserService;

@WebServlet(description = "�޸��ջ���Ϣ", urlPatterns = { "/user/UpdateAddr" })
public class UpdateAddr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateAddr() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �޸��ջ���ַ
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		User u = new User();
		String userName = (String)request.getSession().getAttribute("LoginUser");
		u.setUserName(userName);
		u.setUserAddr(request.getParameter("userAddr"));
		u.setUserPhone(request.getParameter("userPhone"));
		u.setUserConsignee(request.getParameter("userConsignee"));
		// �޸ĵ�ַ
		UserService us = new UserService();
		if(us.updateAddr(u)) {
			// �޸ĳɹ�
			request.getSession().setAttribute("UserAddr", us.getAddr(userName));
			response.sendRedirect(request.getContextPath() +"/user/userAddr.jsp");
		} else {
			// �޸�ʧ��
			response.getWriter().println("<script>alert('ҵ���쳣���޸�ʧ�ܣ�')</script>");
			response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/user/userAddr.jsp");
		}
	}

}
