package adminservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;

@WebServlet(description = "���ݵ�����ɾ������", urlPatterns = { "/admin/DeleteStore" })
public class DeleteStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteStore() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * ���ݵ�����ɾ������
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storeName = request.getParameter("storeName");
		String curPage = request.getParameter("page");
		AdminService as = new AdminService();
		if(!as.deleteStore(storeName)) {
			// ɾ��ʧ�ܣ���ʾ������Ϣ
			response.getWriter().println("<script>alert('ҵ���쳣��ɾ��ʧ�ܣ�')</script>");
		}
		response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/admin/GetAllStore?page="+ curPage);
		
	}

}
