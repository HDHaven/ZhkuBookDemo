package userservlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import service.UserService;

@WebServlet(description = "用户添加订单", urlPatterns = { "/user/AddOrder" })
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddOrder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 用户生成订单
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		List productList = (List) request.getSession().getAttribute("ProductList");
		String userName = (String) request.getSession().getAttribute("LoginUser");
		String orderAddr = request.getParameter("orderAddr");
		String orderConsignee = request.getParameter("orderConsignee");
		String orderPhone = request.getParameter("orderPhone");
		String orderPrice = (String) request.getSession().getAttribute("SumPrice");
		String orderDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
		// 添加订单
		UserService us = new UserService();
		// 生成一条订单
		Order o = new Order(0, orderDate, Integer.parseInt(orderPrice), orderConsignee, orderAddr, orderPhone, userName);
		if(us.addOrder(o, productList)) {
			// 下单成功，跳到订单页面
			response.sendRedirect(request.getContextPath() +"/user/allOrder.jsp");
		} else {
			// 下单失败，提示错误信息
			response.getWriter().println("<script>alert('业务异常，下单失败！')</script>");
			response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/user/addOrder.jsp");
		}
	}

}
