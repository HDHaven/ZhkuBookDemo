package userservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet("/user/UpdateCart")
public class UpdateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �޸Ĺ��ﳵ����Ʒ������
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		int cartId = Integer.parseInt(request.getParameter("cartId"));
		int bookNumber = Integer.parseInt(request.getParameter("bookNumber"));
		// �޸Ĳ���
		UserService us = new UserService();
		if(us.updateCart(cartId, bookNumber)) {
			// �޸ĳɹ������ع��ﳵ
			response.sendRedirect(request.getContextPath() +"/user/GetCart");
		} else {
			// �޸�ʧ��
			response.getWriter().println("<script>alert('ҵ���쳣���޸�ʧ�ܣ�')</script>");
			response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/user/cart1.jsp");
		}
	}

}
