package managerservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import service.ManagerService;

@WebServlet(description = "根据订单状态获取订单信息", urlPatterns = { "/manager/GetOrderByState" })
public class GetOrderByState extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetOrderByState() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 根据订单状态获取订单信息
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取参数
		String storeName = (String) request.getSession().getAttribute("StoreName");
		String orderState = request.getParameter("orderState");
		request.getSession().setAttribute("OrderState", orderState);
		String page = request.getParameter("page");
		int curPage = 1;
		if (page != null && page.length() > 0)
			curPage = Integer.parseInt(page);
		// 获取订单信息
		ManagerService ms = new ManagerService();
		PageBean pb = ms.getOrderByStateInStore(storeName, orderState, curPage);
		// 获取成功，保存，传给前端
		request.getSession().setAttribute("OrderInfo", pb);
		response.sendRedirect(request.getContextPath() + "/manager/orderInfo.jsp");
	}

}
