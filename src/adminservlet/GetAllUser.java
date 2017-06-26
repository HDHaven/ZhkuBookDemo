package adminservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import service.AdminService;

@WebServlet(description = "�鿴�����û�������Ϣ", urlPatterns = { "/admin/GetAllUser" })
public class GetAllUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAllUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * ���ܣ��鿴�����û�������Ϣ����ҳ
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		int curPage = 1;	// �ս���ҳ��ʱ����ʾ��һҳ
		if(page != null && page.length() > 0) {	
			curPage = Integer.parseInt(page);
		}
		AdminService as = new AdminService();
		PageBean pb = as.getAllUserInfo(curPage);	// ��ȡ�û���Ϣ
		if(pb != null) {
			// �����Ϊ�գ��򷵻ظ�ǰ̨
			request.getSession().setAttribute("UserInfo", pb);
			response.sendRedirect(request.getContextPath() +"/admin/userInfo.jsp");
		} else {
			// ��ȡ��Ϣʧ�ܻ�����ϢΪ�գ���ʾ������Ϣ
			response.getWriter().println("<script>alert('ҵ���쳣')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}

	}

}
