package userservlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Cart;
import service.UserService;

@WebServlet(description = "用户将图书加入购物车", urlPatterns = { "/user/AddCart" })
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 用户添加商品进购物车
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String userName = (String) request.getSession().getAttribute("LoginUser");
		Map m = (Map) request.getSession().getAttribute("BookDetail");
		String bookName = (String) m.get("bookName");
		String storeName = (String) m.get("storeName");
		String bookImage = (String) m.get("bookImage");
		int bookNumber = 1;
		int bookPrice = (int) m.get("bookPrice");
		Cart c = new Cart(0, userName, storeName, bookName, bookPrice, bookNumber, bookImage);
		// 加入购物车
		UserService us = new UserService();
		if(us.addBookInCart(c)) {
			// 加入成功，显示购物车
			response.sendRedirect(request.getContextPath() +"/user/GetCart");
		} else {
			// 加入失败，提示错误信息
			response.getWriter().println("<script>alert('业务异常，添加失败！')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
