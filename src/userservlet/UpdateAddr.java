package userservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import service.UserService;

@WebServlet(description = "修改收货信息", urlPatterns = { "/user/UpdateAddr" })
public class UpdateAddr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateAddr() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 修改收货地址
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		User u = new User();
		String userName = (String)request.getSession().getAttribute("LoginUser");
		u.setUserName(userName);
		u.setUserAddr(request.getParameter("userAddr"));
		u.setUserPhone(request.getParameter("userPhone"));
		u.setUserConsignee(request.getParameter("userConsignee"));
		// 修改地址
		UserService us = new UserService();
		if(us.updateAddr(u)) {
			// 修改成功
			request.getSession().setAttribute("UserAddr", us.getAddr(userName));
			response.sendRedirect(request.getContextPath() +"/user/userAddr.jsp");
		} else {
			// 修改失败
			response.getWriter().println("<script>alert('业务异常，修改失败！')</script>");
			response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/user/userAddr.jsp");
		}
	}

}
