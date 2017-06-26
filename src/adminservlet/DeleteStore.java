package adminservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;

@WebServlet(description = "根据店铺名删除店铺", urlPatterns = { "/admin/DeleteStore" })
public class DeleteStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteStore() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 根据店铺名删除店铺
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storeName = request.getParameter("storeName");
		String curPage = request.getParameter("page");
		AdminService as = new AdminService();
		if(!as.deleteStore(storeName)) {
			// 删除失败，提示错误信息
			response.getWriter().println("<script>alert('业务异常，删除失败！')</script>");
		}
		response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/admin/GetAllStore?page="+ curPage);
		
	}

}
