package adminservlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import service.AdminService;

@WebServlet(description = "��ȡ���̶�����Ϣ", urlPatterns = { "/admin/GetStoreOrder" })
public class GetStoreOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetStoreOrder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �鿴���̶�����Ϣ
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storeName = request.getParameter("storeName");
		String page = request.getParameter("page");
		int curPage = 1;
		if(page != null && page.length() > 0)
			curPage = Integer.parseInt(page);
		// ���ݵ�������ȡ���̶��������ظ�ǰ��
		AdminService as = new AdminService();
		Map m = as.getStoreByName(storeName);
		PageBean pb = as.getOrderInfoByStoreName(storeName, curPage);
		request.getSession().setAttribute("AStore", m);
		request.getSession().setAttribute("StoreOrder", pb);
		response.sendRedirect(request.getContextPath() +"/admin/storeOrder.jsp");
	}

}
