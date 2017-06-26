package adminservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;

/**
 * Servlet implementation class GetOrderProduct
 */
@WebServlet(description = "��ȡ������Ʒ��Ϣ", urlPatterns = { "/admin/GetOrderProduct" })
public class GetOrderProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetOrderProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * ���ܣ��鿴������������Ʒ��Ϣ
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		String userName = request.getParameter("userName");
		AdminService as = new AdminService();
		// ��ȡ��Ʒ��Ϣ������ǰ��
		List productList = as.getOrderProductById(Integer.parseInt(orderId));
		request.getSession().setAttribute("ProductList", productList);
		response.sendRedirect(request.getContextPath() +"/admin/productList.jsp?orderId="+ orderId +"&userName="+ userName);
	}

}
