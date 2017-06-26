package userservlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import service.UserService;

@WebServlet(description = "�û���Ӷ���", urlPatterns = { "/user/AddOrder" })
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddOrder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �û����ɶ���
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		List productList = (List) request.getSession().getAttribute("ProductList");
		String userName = (String) request.getSession().getAttribute("LoginUser");
		String orderAddr = request.getParameter("orderAddr");
		String orderConsignee = request.getParameter("orderConsignee");
		String orderPhone = request.getParameter("orderPhone");
		String orderPrice = (String) request.getSession().getAttribute("SumPrice");
		String orderDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
		// ��Ӷ���
		UserService us = new UserService();
		// ����һ������
		Order o = new Order(0, orderDate, Integer.parseInt(orderPrice), orderConsignee, orderAddr, orderPhone, userName);
		if(us.addOrder(o, productList)) {
			// �µ��ɹ�����������ҳ��
			response.sendRedirect(request.getContextPath() +"/user/allOrder.jsp");
		} else {
			// �µ�ʧ�ܣ���ʾ������Ϣ
			response.getWriter().println("<script>alert('ҵ���쳣���µ�ʧ�ܣ�')</script>");
			response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/user/addOrder.jsp");
		}
	}

}
