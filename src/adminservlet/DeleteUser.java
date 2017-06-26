package adminservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;

@WebServlet(description = "�����û���ɾ���û�", urlPatterns = { "/admin/DeleteUser" })
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * ���ܣ������û���ɾ���û�
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String curPage = request.getParameter("page");
		AdminService as = new AdminService();
		if(as.deleteUserByName(userName)) {
			// ɾ���ɹ������»�ȡ��ǰҳ���û���Ϣ
			response.sendRedirect(request.getContextPath() +"/admin/GetAllUser?page="+ curPage);
		} else {
			// ɾ��ʧ�ܣ���ʾ������Ϣ��������һҳ
			response.getWriter().println("<script>alert('ҵ���쳣')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
