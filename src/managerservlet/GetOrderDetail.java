package managerservlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ManagerService;

@WebServlet(name = "GetOrderDetails", description = "���ݶ�����Ż�ȡ�����ջ���ַ��", urlPatterns = { "/manager/GetOrderDetails" })
public class GetOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetOrderDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * ���ݶ�����Ż�ȡ�����ջ���Ϣ��
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		String orderId = request.getParameter("orderId");
		// ��ȡ������Ϣ
		ManagerService ms = new ManagerService();
		Map m = ms.getOrderDetailById(Integer.parseInt(orderId));
		if(m != null) {
			// ��ȡ�ɹ������棬����ǰ��
			request.getSession().setAttribute("OrderDetail", m);
			response.sendRedirect(request.getContextPath() +"/manager/orderDetails.jsp");
		} else {
			// ��ȡʧ�ܣ���ʾ������Ϣ������
			response.getWriter().println("<script>alert('ҵ���쳣����ȡʧ��')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
