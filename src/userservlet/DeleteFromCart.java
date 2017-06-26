package userservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet(description = "�ӹ��ﳵ�Ƴ���Ʒ", urlPatterns = { "/user/DeleteFromCart" })
public class DeleteFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteFromCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		String cartId = request.getParameter("cartId");
		// �ӹ��ﳵ���Ƴ�
		UserService us = new UserService();
		if(us.deleteFromCart(Integer.parseInt(cartId))) {
			// ɾ���ɹ���������ʾ���ﳵ
			response.sendRedirect(request.getContextPath() +"/user/GetCart");
		} else {
			// ɾ��ʧ�ܣ���ʾ����
			response.getWriter().println("<script>alert('ҵ���쳣��ɾ��ʧ��')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
