package adminservlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;

@WebServlet(description = "查看店铺订单详细信息", urlPatterns = { "/admin/GetOrderDetail" })
public class GetOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetOrderDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 功能：查看店铺订单详细信息
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		// 根据订单编号获取订单详细信息
		AdminService as = new AdminService();
		Map m = as.getOrderDetailById(Integer.parseInt(orderId));
		request.getSession().setAttribute("OrderDetail", m);
		response.sendRedirect(request.getContextPath() +"/admin/orderDetail.jsp");
	}

}
