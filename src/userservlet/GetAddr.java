package userservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet(description = "�û��鿴������Ϣ", urlPatterns = { "/user/GetAddr" })
public class GetAddr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAddr() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �鿴������Ϣ
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("LoginUser");
		UserService us = new UserService();
		request.getSession().setAttribute("UserAddr", us.getAddr(userName));
		response.sendRedirect(request.getContextPath() +"/user/userAddr.jsp");
	}

}
