package adminservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import service.AdminService;

@WebServlet("/admin/GetUserOrder")
public class GetUserOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetUserOrder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 功能：查看用户订单
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String page = request.getParameter("page");
		int curPage = 1;	// 刚进入页面时，显示第一页
		if(page != null && page.length() > 0) {	
			curPage = Integer.parseInt(page);
		}
		AdminService as = new AdminService();
		// 获取订单信息，返回前台
		PageBean pb = as.getOrderByUserName(userName, curPage);
		request.getSession().setAttribute("UserOrder", pb);
		request.getRequestDispatcher("/admin/userOrder.jsp").forward(request, response);
	}

}
