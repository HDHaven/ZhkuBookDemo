package userservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet(name = "GetOrderProducts", urlPatterns = { "/user/GetOrderProducts" })
public class GetOrderProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetOrderProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 查看订单包含的商品信息
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String orderId = request.getParameter("orderId");
		// 获取商品信息
		UserService us = new UserService();
		List productList = us.getOrderProductById(Integer.parseInt(orderId));
		if(productList != null) {
			// 获取成功，保存，传给前端
			request.getSession().setAttribute("ProductInfo", productList);
			request.getSession().setAttribute("Order", us.getOrderById(Integer.parseInt(orderId)));
			response.sendRedirect(request.getContextPath() +"/user/orderDetail.jsp");
		} else {
			// 获取失败，提示错误信息，返回上一页
			response.getWriter().println("<script>alert('业务异常，获取失败！')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
