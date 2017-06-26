package userservlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet(name = "EnterStores", description = "�û��������", urlPatterns = { "/EnterStores" })
public class EnterStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EnterStore() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �û�������̣���ȡ����������»��������
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		String storeName = request.getParameter("storeName");
		// �������
		UserService us = new UserService();
		Map m = us.enterStore(storeName);
		if(m != null) {
			// �ɹ�������̣���ȡ�����ϴ����������ͼ�飬����ǰ��
			request.getSession().setAttribute("StoreInfo", m);
			request.getSession().setAttribute("StoreNewUpload", us.getBookByLastDate(storeName));
			request.getSession().setAttribute("StoreHotSale", us.getBookByHotSale(storeName));
			response.sendRedirect(request.getContextPath() +"/store.jsp");
		} else {
			// ����ʧ��
			response.getWriter().println("<script>alert('ҵ���쳣��')</script>");
			response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/index.jsp");
		}
	}

}
