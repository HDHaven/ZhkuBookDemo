package managerservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ManagerService;

@WebServlet(description = "根据图书编号删除图书", urlPatterns = { "/manager/DeleteBook" })
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 根据图书编号删除图书
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String bookId = request.getParameter("bookId");
		String curPage = request.getParameter("page");
		// 删除图书
		ManagerService ms = new ManagerService();
		if(ms.deleteBook(Integer.parseInt(bookId))) {
			// 删除成功，返回图书当前页
			response.sendRedirect(request.getContextPath() +"/manager/GetBook?page="+ curPage);
		} else {
			// 删除失败，提示错误信息，返回
			response.getWriter().println("<script>alert('业务异常，修改失败！')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
