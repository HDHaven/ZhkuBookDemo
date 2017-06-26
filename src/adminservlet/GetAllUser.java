package adminservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import service.AdminService;

@WebServlet(description = "查看所有用户基本信息", urlPatterns = { "/admin/GetAllUser" })
public class GetAllUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAllUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 功能：查看所有用户基本信息，分页
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		int curPage = 1;	// 刚进入页面时，显示第一页
		if(page != null && page.length() > 0) {	
			curPage = Integer.parseInt(page);
		}
		AdminService as = new AdminService();
		PageBean pb = as.getAllUserInfo(curPage);	// 获取用户信息
		if(pb != null) {
			// 如果不为空，则返回给前台
			request.getSession().setAttribute("UserInfo", pb);
			response.sendRedirect(request.getContextPath() +"/admin/userInfo.jsp");
		} else {
			// 获取信息失败或者信息为空，提示错误信息
			response.getWriter().println("<script>alert('业务异常')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}

	}

}
