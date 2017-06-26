package adminservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import service.AdminService;

@WebServlet(description = "��ȡ���������Ϣ", urlPatterns = { "/admin/GetTempStore" })
public class GetTempStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetTempStore() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		int curPage = 1;
		if(page != null && page.length() > 0) {
			curPage = Integer.parseInt(page);
		}
		AdminService as = new AdminService();
		// ��ȡ��ʱ������Ϣ������ǰ��
		PageBean pb = as.getStoreInfoInTempStore(curPage);
		request.getSession().setAttribute("TempStoreInfo", pb);
		response.sendRedirect(request.getContextPath() +"/admin/tempStoreInfo.jsp");
	}

}
