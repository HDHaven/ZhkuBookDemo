package userservlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Cart;
import service.UserService;

@WebServlet(description = "�û���ͼ����빺�ﳵ", urlPatterns = { "/user/AddCart" })
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �û������Ʒ�����ﳵ
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		String userName = (String) request.getSession().getAttribute("LoginUser");
		Map m = (Map) request.getSession().getAttribute("BookDetail");
		String bookName = (String) m.get("bookName");
		String storeName = (String) m.get("storeName");
		String bookImage = (String) m.get("bookImage");
		int bookNumber = 1;
		int bookPrice = (int) m.get("bookPrice");
		Cart c = new Cart(0, userName, storeName, bookName, bookPrice, bookNumber, bookImage);
		// ���빺�ﳵ
		UserService us = new UserService();
		if(us.addBookInCart(c)) {
			// ����ɹ�����ʾ���ﳵ
			response.sendRedirect(request.getContextPath() +"/user/GetCart");
		} else {
			// ����ʧ�ܣ���ʾ������Ϣ
			response.getWriter().println("<script>alert('ҵ���쳣�����ʧ�ܣ�')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
