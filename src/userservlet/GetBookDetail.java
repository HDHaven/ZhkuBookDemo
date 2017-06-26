package userservlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet(description = "查看图书详细信息", urlPatterns = { "/GetBookDetail" })
public class GetBookDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBookDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 查看图书详细信息，包括评论
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String bookId = request.getParameter("bookId");
		String page = request.getParameter("page");
		int curPage = page==null?1:Integer.parseInt(page);
		// 获取图书信息
		UserService us = new UserService();
		Map m = us.getBookById(Integer.parseInt(bookId));
		if(m != null) {
			// 成功获取图书信息，获取图书评论
			String storeName = (String) m.get("storeName");
			String bookName = (String) m.get("bookName");
			request.getSession().setAttribute("BookComment", us.getBookComment(storeName, bookName, curPage));
			request.getSession().setAttribute("BookDetail", m);
			response.sendRedirect(request.getContextPath() +"/bookDetail.jsp");
		} else {
			// 获取失败
			response.getWriter().println("<script>alert('业务异常！')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
