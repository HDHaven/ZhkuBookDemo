package managerservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import service.ManagerService;

@WebServlet(description = "根据书名查询图书", urlPatterns = { "/manager/GetBookByName" })
public class GetBookByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBookByName() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 根据书名获取图书
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String storeName = (String) request.getSession().getAttribute("StoreName");
		String bookName = request.getParameter("bookName");
		request.getSession().setAttribute("BookName", bookName);
		String page = request.getParameter("page");
		int curPage = 1;
		if(page != null && page.length() > 0)
			curPage = Integer.parseInt(page);
		// 获取图书信息
		ManagerService ms = new ManagerService();
		PageBean pb = ms.getBookByNameInStore(storeName, bookName, curPage);
		if(pb != null) {
			// 获取成功，保存数据，传给前端
			request.getSession().setAttribute("BookInfo", pb);
			response.sendRedirect(request.getContextPath() +"/manager/bookInfo.jsp");
		} else {
			// 查询结果错误或者为空，提示错误信息
			response.getWriter().println("<script>alert('查询结果为空！')</script>");
			response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/manager/bookInfo.jsp");
		}
	}

}
