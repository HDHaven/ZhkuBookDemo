package adminservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;

@WebServlet(description = "根据用户名删除用户", urlPatterns = { "/admin/DeleteUser" })
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 功能：根据用户名删除用户
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String curPage = request.getParameter("page");
		AdminService as = new AdminService();
		if(as.deleteUserByName(userName)) {
			// 删除成功，重新获取当前页的用户信息
			response.sendRedirect(request.getContextPath() +"/admin/GetAllUser?page="+ curPage);
		} else {
			// 删除失败，提示错误信息，返回上一页
			response.getWriter().println("<script>alert('业务异常')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
