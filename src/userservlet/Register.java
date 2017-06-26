package userservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet(description = "处理用户注册", urlPatterns = { "/Register" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 处理用户注册
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		// 注册
		UserService us = new UserService();
		int recNo = us.register(userName, password);
		if(recNo == 2) {
			// 注册成功，设置权限，跳转到首页
			request.getSession().setAttribute("LoginUser", userName);
			response.sendRedirect(request.getContextPath() +"/index.jsp");
		} else {
			// 注册失败，提示错误信息，返回上一页。
			String msg = "业务异常，注册失败！";
			if(recNo == 1)
				msg = "用户名已存在咯";
			response.getWriter().println("<script>alert('"+ msg +"')</script>");
			response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/register.jsp");
		}
	}

}
