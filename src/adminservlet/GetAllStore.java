package adminservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;

@WebServlet(description = "�鿴���е�����Ϣ", urlPatterns = { "/admin/GetAllStore" })
public class GetAllStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAllStore() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �鿴���е��̵���Ϣ����ҳ
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		int curPage = 1;
		if(page != null && page.length() > 0)
			curPage = Integer.parseInt(page);
		// ��ȡ������Ϣ
		AdminService as = new AdminService();
		request.getSession().setAttribute("StoreInfo", as.getAllStoreInfo(curPage));
		// ��ת��������Ϣҳ��
		response.sendRedirect(request.getContextPath() +"/admin/storeInfo.jsp");
	}

}
