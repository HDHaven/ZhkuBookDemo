package userservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet(description = "从购物车移除商品", urlPatterns = { "/user/DeleteFromCart" })
public class DeleteFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteFromCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String cartId = request.getParameter("cartId");
		// 从购物车中移除
		UserService us = new UserService();
		if(us.deleteFromCart(Integer.parseInt(cartId))) {
			// 删除成功，重新显示购物车
			response.sendRedirect(request.getContextPath() +"/user/GetCart");
		} else {
			// 删除失败，提示错误
			response.getWriter().println("<script>alert('业务异常，删除失败')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
