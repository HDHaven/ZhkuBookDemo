package userservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import service.UserService;

@WebServlet(name = "GetBookInfoByName", description = "根据图书名获取图书信息", urlPatterns = { "/GetBookInfoByName" })
public class GetBookByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBookByName() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 根据图书名查询图书
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String bookName = request.getParameter("bookName");
		request.getSession().setAttribute("SearchName", bookName);
		request.getSession().removeAttribute("SearchClass");
		String storeName = request.getParameter("storeName");
		String page = request.getParameter("page");
		int curPage = page==null?1:Integer.parseInt(page);
		// 获取图书
		UserService us = new UserService();
		PageBean pb = us.getBookByName(storeName, bookName, curPage);
		String url = "/index.jsp";
		url = storeName==null?url:"/store.jsp";
		if(pb != null) {
			// 查询成功，保存，传给前端
			request.getSession().setAttribute("BookInfo", pb);
			response.sendRedirect(request.getContextPath() + url);
		} else {
			// 查询失败
			response.getWriter().println("<script>alert('查询结果为空！')</script>");
			response.setHeader("Refresh", "1; url="+ request.getContextPath() + url);
		}
	}

}
