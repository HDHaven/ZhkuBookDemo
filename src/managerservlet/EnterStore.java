package managerservlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ManagerService;

@WebServlet(description = "��ҽ�����̷��ص�����Ϣ", urlPatterns = { "/manager/EnterStore" })
public class EnterStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EnterStore() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * ��ҽ����Լҵ��̶�ͼ��Ͷ������д���
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("ManagerUser");
		// ��ȡ���̻�����Ϣ
		ManagerService ms = new ManagerService();
		Map m = ms.enterStore(userName);
		if(m != null) {
			// ��ȡ�ɹ����������
			request.getSession().setAttribute("StoreInfo", m);
			request.getSession().setAttribute("StoreName", m.get("storeName"));
			response.sendRedirect(request.getContextPath() +"/manager/index.jsp");
		} else {
			// ����ʧ�ܣ���ʾ������Ϣ
			response.getWriter().println("<script>alert('ҵ���쳣���޷��������')</script>");
			response.setHeader("Refresh", "1; url=javascript:hisotry.go(-1)");
		}
	}

}
