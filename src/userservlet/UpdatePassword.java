package userservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import service.UserService;

@WebServlet(description = "�޸�����", urlPatterns = { "/user/UpdatePassword" })
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdatePassword() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �޸��û�����
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		String userName = (String) request.getSession().getAttribute("LoginUser");
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		// �޸�����
		UserService us = new UserService();
		User u = new User();
		u.setUserName(userName);
		u.setPassword(password);
		int recNo = us.updatePassword(u, newPassword);
		String msg = "ҵ���쳣���޸�ʧ��";
		if(recNo == 2) {
			// �޸ĳɹ�
			msg = "�޸ĳɹ�";
		} else {
			// �޸�ʧ��
			if(recNo == 0)
				msg = "ԭ���벻��ȷ";
		}
		response.getWriter().println("<script>alert('"+ msg +"')</script>");
		response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/user/updatePassword.jsp");
	}

}
