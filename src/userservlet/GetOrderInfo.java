package userservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import service.UserService;

@WebServlet(description = "用户查看自己的订单", urlPatterns = { "/user/GetOrderInfo" })
public class GetOrderInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetOrderInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 用户查看自己所有的订单
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// 获取参数
		String userName = (String) request.getSession().getAttribute("LoginUser");
		String orderState = request.getParameter("orderState");
		String page = request.getParameter("page");
		int curPage = page==null?1:Integer.parseInt(page);
		// 获取订单信息
		UserService us = new UserService();
		PageBean pb = us.getOrder(userName, orderState, curPage);
		request.getSession().setAttribute("OrderInfo", pb);
		orderState = orderState==null?null:getPath(orderState);
		if(orderState != null) {
			// 如果是根据状态获取，则跳转到对应状态的页面 	
			response.sendRedirect(request.getContextPath() +"/user/"+ orderState +"Order.jsp");
			return;
		}
		// 所有订单页面
		response.sendRedirect(request.getContextPath() +"/user/allOrder.jsp");
	}
	
	
	public String getPath(String orderState) {
		String path = null;
		if(orderState.equals("待处理")) {
			path = "waitDeal";
		} else if(orderState.equals("待审核")) {
			path = "waitCheck";
		} else if(orderState.equals("正在配送")) {
			path = "peiSong";
		} else if(orderState.equals("已完成")) {
			path = "finish";
		}
		return path;
	}
	

}
