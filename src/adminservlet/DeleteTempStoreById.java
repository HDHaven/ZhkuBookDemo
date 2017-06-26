package adminservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;

@WebServlet(description = "ɾ����ʱ���̱���Ϣ", urlPatterns = { "/admin/DeleteTempStoreById" })
public class DeleteTempStoreById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteTempStoreById() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * ɾ����ʱ���̱���Ϣ
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		String tempStoreId = request.getParameter("tempStoreId");
		String page = request.getParameter("page");
		int curPage = page==null?1:Integer.parseInt(page);
		// ɾ������
		AdminService as = new AdminService();
		if(as.deleteTempStoreById(Integer.parseInt(tempStoreId))) {
			// ɾ���ɹ������ص�ǰҳ
			response.sendRedirect(request.getContextPath() +"/admin/GetTempStore/?page="+ curPage);
		} else {
			// ɾ��ʧ��
			response.getWriter().println("<script>alert('ҵ���쳣��ɾ��ʧ�ܣ�')</script>");
			response.setHeader("Refresh", request.getContextPath() +"/tempStoreInfo.jsp");
		}
		
	}

}
