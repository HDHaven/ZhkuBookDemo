package userservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet(description = "处理用户登录", urlPatterns = { "/DoLogin" })
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 处理用户登录
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		// 处理登录
		UserService us = new UserService();
		int userType = us.login(userName, password);
		if(userType == 1) {
			// 会员，设置权限
			request.getSession().setAttribute("LoginUser", userName);
			request.getSession().setAttribute("UserAddr", us.getAddr(userName));
			if(us.isManager(userName)) {
				// 还有自己的店铺
				request.getSession().setAttribute("ManagerUser", userName);
			}
			// 登录成功，跳转到首页
			response.sendRedirect(request.getContextPath() +"/index.jsp");
		} else if(userType == 2) {
			// 管理员，设置权限，跳转到管理首页
			request.getSession().setAttribute("AdminUser", userName);
			response.sendRedirect(request.getContextPath() +"/admin/index.jsp");
		} else {
			// 登录失败，返回上一页
			response.getWriter().println("<script>alert('用户名与密码不匹配！')</script>");
			response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/login.jsp");
		}
	}

}
