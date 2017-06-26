package userservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet("/user/UpdateCart")
public class UpdateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 修改购物车中商品的数量
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		int cartId = Integer.parseInt(request.getParameter("cartId"));
		int bookNumber = Integer.parseInt(request.getParameter("bookNumber"));
		// 修改操作
		UserService us = new UserService();
		if(us.updateCart(cartId, bookNumber)) {
			// 修改成功，返回购物车
			response.sendRedirect(request.getContextPath() +"/user/GetCart");
		} else {
			// 修改失败
			response.getWriter().println("<script>alert('业务异常，修改失败！')</script>");
			response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/user/cart1.jsp");
		}
	}

}
