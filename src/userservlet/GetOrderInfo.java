package userservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import service.UserService;

@WebServlet(description = "�û��鿴�Լ��Ķ���", urlPatterns = { "/user/GetOrderInfo" })
public class GetOrderInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetOrderInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �û��鿴�Լ����еĶ���
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// ��ȡ����
		String userName = (String) request.getSession().getAttribute("LoginUser");
		String orderState = request.getParameter("orderState");
		String page = request.getParameter("page");
		int curPage = page==null?1:Integer.parseInt(page);
		// ��ȡ������Ϣ
		UserService us = new UserService();
		PageBean pb = us.getOrder(userName, orderState, curPage);
		request.getSession().setAttribute("OrderInfo", pb);
		orderState = orderState==null?null:getPath(orderState);
		if(orderState != null) {
			// ����Ǹ���״̬��ȡ������ת����Ӧ״̬��ҳ�� 	
			response.sendRedirect(request.getContextPath() +"/user/"+ orderState +"Order.jsp");
			return;
		}
		// ���ж���ҳ��
		response.sendRedirect(request.getContextPath() +"/user/allOrder.jsp");
	}
	
	
	public String getPath(String orderState) {
		String path = null;
		if(orderState.equals("������")) {
			path = "waitDeal";
		} else if(orderState.equals("�����")) {
			path = "waitCheck";
		} else if(orderState.equals("��������")) {
			path = "peiSong";
		} else if(orderState.equals("�����")) {
			path = "finish";
		}
		return path;
	}
	

}
