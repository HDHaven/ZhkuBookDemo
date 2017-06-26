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
		// ��ȡ����
		String productId = request.getParameter("productId");
		String orderState = "�����";
		// �޸�
		UserService us = new UserService();
		if(us.updateOrderState(Integer.parseInt(productId), orderState)) {
			// �޸ĳɹ�
			response.sendRedirect(request.getContextPath() +"/user/finishOrder.jsp");
		} else {
			// �޸�ʧ��
			response.getWriter().println("<script>alert('ȷ���ջ�ʧ�ܣ�')</script>");
			response.setHeader("Refresh", "2; url="+ request.getContextPath() +"/user/peiSongOrder.jsp");
		}
	}

}
