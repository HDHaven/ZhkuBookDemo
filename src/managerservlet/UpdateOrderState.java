package managerservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ManagerService;

@WebServlet(description = "�޸Ķ���״̬", urlPatterns = { "/manager/UpdateOrderState" })
public class UpdateOrderState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateOrderState() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * ���ݶ�������޸Ķ���״̬
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		String productId = request.getParameter("productId");
		String orderState = request.getParameter("orderState");
		String curPage = request.getParameter("page");
		// �޸Ķ���״̬
		ManagerService ms = new ManagerService();
		if(ms.updateOrderState(Integer.parseInt(productId), orderState)) {
			// �޸ĳɹ������»�ȡ��ҳ������Ϣ
			response.sendRedirect(request.getContextPath() +"/manager/GetOrder?page="+ curPage);
		} else {
			// �޸�ʧ�ܣ���ʾ������Ϣ������
			response.getWriter().println("<script>alert('ҵ���쳣���޸�ʧ�ܣ�')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
