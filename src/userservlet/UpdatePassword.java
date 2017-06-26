package userservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import service.UserService;

@WebServlet(description = "修改密码", urlPatterns = { "/user/UpdatePassword" })
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdatePassword() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 修改用户密码
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String userName = (String) request.getSession().getAttribute("LoginUser");
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		// 修改密码
		UserService us = new UserService();
		User u = new User();
		u.setUserName(userName);
		u.setPassword(password);
		int recNo = us.updatePassword(u, newPassword);
		String msg = "业务异常，修改失败";
		if(recNo == 2) {
			// 修改成功
			msg = "修改成功";
		} else {
			// 修改失败
			if(recNo == 0)
				msg = "原密码不正确";
		}
		response.getWriter().println("<script>alert('"+ msg +"')</script>");
		response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/user/updatePassword.jsp");
	}

}
