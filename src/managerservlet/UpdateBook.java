package managerservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ManagerService;

@WebServlet(description = "修改图书价格获取库存量", urlPatterns = { "/manager/UpdateBook" })
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 修改图书的价格或者库存量
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String bookPrice = request.getParameter("bookPrice");
		String bookSumNum = request.getParameter("bookSumNum");
		String curPage = request.getParameter("page");
		// 修改图书信息
		ManagerService ms = new ManagerService();
		if(bookPrice != null && ms.updateBookPrice(bookId, Integer.parseInt(bookPrice))) {
			// 修改价格成功
			response.sendRedirect(request.getContextPath() +"/manager/GetBook?page="+ curPage);
		} else if(bookSumNum != null && ms.updateBookSumNum(bookId, Integer.parseInt(bookSumNum))) {
			// 修改库存量成功，重新返回当前页图书信息
			response.sendRedirect(request.getContextPath() +"/manager/GetBook?page="+ curPage);
		} else {
			// 修改失败，提示错误信息，返回。
			response.getWriter().println("<script>alert('业务异常，修改失败')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
