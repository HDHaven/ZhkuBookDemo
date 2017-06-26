package userservlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet("/user/GetBookDetails")
public class GetBookDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBookDetails() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 根据图书名称和店铺名获取图书详细信息
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String storeName = request.getParameter("storeName");
		String bookName = request.getParameter("bookName");
		// 获取图书信息
		UserService us = new UserService();
		Map m = us.getABook(storeName, bookName);
		if(m != null) {
			// 获取成功
			request.getSession().setAttribute("BookDetail", m);
			request.getSession().setAttribute("BooKComment", us.getBookComment(storeName, bookName, 1));
			response.sendRedirect(request.getContextPath() +"/bookDetail.jsp");
		} else {
			// 获取失败
			response.getWriter().println("<script>alert('业务异常！')</script>");
			response.setHeader("Refresh", "2; url="+ request.getContextPath() +"/index.jsp");
		}
		
	}

}
