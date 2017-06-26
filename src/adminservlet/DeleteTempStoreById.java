package adminservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;

@WebServlet(description = "删除临时店铺表信息", urlPatterns = { "/admin/DeleteTempStoreById" })
public class DeleteTempStoreById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteTempStoreById() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 删除临时店铺表信息
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String tempStoreId = request.getParameter("tempStoreId");
		String page = request.getParameter("page");
		int curPage = page==null?1:Integer.parseInt(page);
		// 删除操作
		AdminService as = new AdminService();
		if(as.deleteTempStoreById(Integer.parseInt(tempStoreId))) {
			// 删除成功，返回当前页
			response.sendRedirect(request.getContextPath() +"/admin/GetTempStore/?page="+ curPage);
		} else {
			// 删除失败
			response.getWriter().println("<script>alert('业务异常，删除失败！')</script>");
			response.setHeader("Refresh", request.getContextPath() +"/tempStoreInfo.jsp");
		}
		
	}

}
