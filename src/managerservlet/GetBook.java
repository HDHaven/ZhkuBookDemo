package managerservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import service.ManagerService;

@WebServlet(description = "店家获取店铺所有图书", urlPatterns = { "/manager/GetBook" })
public class GetBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 店家查看店铺内所有图书
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String storeName = (String) request.getSession().getAttribute("StoreName");
		String page = request.getParameter("page");
		request.getSession().removeAttribute("BookName");
		int curPage = 1;
		if(page != null && page.length() > 0)
			curPage = Integer.parseInt(page);
		// 获取当前页的图书
		ManagerService ms = new ManagerService();
		PageBean pb = ms.getBookByStoreName(storeName, curPage);
		// 保存图书，传到前端
		request.getSession().setAttribute("BookInfo", pb);
		response.sendRedirect(request.getContextPath() +"/manager/bookInfo.jsp");
	}

}
