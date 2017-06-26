package userservlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet(name = "GetOrderDetailss", description = "查看订单详情", urlPatterns = { "/user/GetOrderDetailss" })
public class GetOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetOrderDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 用户查看订单详情
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String orderId = request.getParameter("orderId");
		// 获取订单详情
		UserService us = new UserService();
		Map m = us.getOrderById(Integer.parseInt(orderId));
		if(m != null) {
			// 获取成功，保存，传给前端
			request.getSession().setAttribute("OrderDetail", m);
			response.sendRedirect(request.getContextPath() +"/user/orderDetails.jsp");
		} else {
			// 获取失败，提示错误信息
			response.getWriter().println("<script>alert('业务异常，获取失败')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
