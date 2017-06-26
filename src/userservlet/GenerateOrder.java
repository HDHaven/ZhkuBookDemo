package userservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet(description = "从购物车中生成订单", urlPatterns = { "/user/GenerateOrder" })
public class GenerateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GenerateOrder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 从购物车获取被选中的商品，生成订单
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String userName = (String) request.getSession().getAttribute("LoginUser");
		String sumPrice = request.getParameter("sumPrice");	// 订单总价
		// 获取选中的商品
		UserService us = new UserService();
		List productList = us.getProdcutList(userName, request);
		if(productList != null && productList.size() > 0) {
			// 获取成功，保存，传给前端
			request.getSession().setAttribute("SumPrice", sumPrice);
			request.getSession().setAttribute("ProductList", productList);
			response.sendRedirect(request.getContextPath() +"/user/addOrder.jsp");
		} else {
			// 获取失败，提示错误信息
			response.getWriter().println("<script>alert('业务异常，结算失败！')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
