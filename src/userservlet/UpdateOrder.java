package userservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

/**
 * Servlet implementation class UpdateOrder
 */
@WebServlet("/user/UpdateOrder")
public class UpdateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrder() {
        super();
    }

	/**
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String productId = request.getParameter("productId");
		String orderState = "已完成";
		// 修改
		UserService us = new UserService();
		if(us.updateOrderState(Integer.parseInt(productId), orderState)) {
			// 修改成功
			response.sendRedirect(request.getContextPath() +"/user/finishOrder.jsp");
		} else {
			// 修改失败
			response.getWriter().println("<script>alert('确认收货失败！')</script>");
			response.setHeader("Refresh", "2; url="+ request.getContextPath() +"/user/peiSongOrder.jsp");
		}
	}

}
