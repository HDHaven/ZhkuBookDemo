package adminservlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;

@WebServlet(description = "�鿴���̶�����ϸ��Ϣ", urlPatterns = { "/admin/GetOrderDetail" })
public class GetOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetOrderDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * ���ܣ��鿴���̶�����ϸ��Ϣ
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		// ���ݶ�����Ż�ȡ������ϸ��Ϣ
		AdminService as = new AdminService();
		Map m = as.getOrderDetailById(Integer.parseInt(orderId));
		request.getSession().setAttribute("OrderDetail", m);
		response.sendRedirect(request.getContextPath() +"/admin/orderDetail.jsp");
	}

}
