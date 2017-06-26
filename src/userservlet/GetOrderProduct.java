package userservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet(name = "GetOrderProducts", urlPatterns = { "/user/GetOrderProducts" })
public class GetOrderProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetOrderProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �鿴������������Ʒ��Ϣ
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		String orderId = request.getParameter("orderId");
		// ��ȡ��Ʒ��Ϣ
		UserService us = new UserService();
		List productList = us.getOrderProductById(Integer.parseInt(orderId));
		if(productList != null) {
			// ��ȡ�ɹ������棬����ǰ��
			request.getSession().setAttribute("ProductInfo", productList);
			request.getSession().setAttribute("Order", us.getOrderById(Integer.parseInt(orderId)));
			response.sendRedirect(request.getContextPath() +"/user/orderDetail.jsp");
		} else {
			// ��ȡʧ�ܣ���ʾ������Ϣ��������һҳ
			response.getWriter().println("<script>alert('ҵ���쳣����ȡʧ�ܣ�')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
