package userservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import service.UserService;

@WebServlet(description = "根据图书类别获取图书", urlPatterns = { "/GetBookInfoByClass" })
public class GetBookInfoByClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBookInfoByClass() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 根据图书类别查询图书
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String bookClass = request.getParameter("bookClass");
		request.getSession().setAttribute("SearchClass", bookClass);
		request.getSession().removeAttribute("SearchName");
		String storeName = request.getParameter("storeName");
		String page = request.getParameter("page");
		int curPage = page==null?1:Integer.parseInt(page);
		// 查询图书
		UserService us = new UserService();
		PageBean pb = us.getBookByClass(storeName, bookClass, curPage);
		if(pb != null) {
			// 查询成功，保存，传给前端
			request.getSession().setAttribute("BookInfo", pb);
			String url = "/index.jsp";
			url = storeName==null?url:"/store.jsp";
			response.sendRedirect(request.getContextPath() + url);
		} else {
			// 查询失败
			response.getWriter().println("<script>alert('业务异常，查询失败！')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
