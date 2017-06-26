package managerservlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ManagerService;

@WebServlet(name = "GetOrderDetails", description = "根据订单编号获取订单收货地址等", urlPatterns = { "/manager/GetOrderDetails" })
public class GetOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetOrderDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 根据订单编号获取订单收货信息等
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String orderId = request.getParameter("orderId");
		// 获取订单信息
		ManagerService ms = new ManagerService();
		Map m = ms.getOrderDetailById(Integer.parseInt(orderId));
		if(m != null) {
			// 获取成功，保存，传给前端
			request.getSession().setAttribute("OrderDetail", m);
			response.sendRedirect(request.getContextPath() +"/manager/orderDetails.jsp");
		} else {
			// 获取失败，提示错误信息，返回
			response.getWriter().println("<script>alert('业务异常，获取失败')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
