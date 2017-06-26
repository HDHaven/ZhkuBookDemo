package userservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet(description = "�û��鿴���ﳵ", urlPatterns = { "/user/GetCart" })
public class GetCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetCart() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �û��鿴�Լ��Ĺ��ﳵ��Ϣ
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("LoginUser");
		UserService us = new UserService();
		Map m = us.getCartByUserName(userName);
		List<String> storeList = null;
		if(m != null) {
			Set s = m.keySet();
			storeList = new ArrayList<String>();
			for (Object obj : s) {
				String storeName = (String) obj;
				storeList.add(storeName);
			}
		}
		request.getSession().setAttribute("StoreList", storeList);
		// ��ȡ�ɹ������棬����ǰ��
		request.getSession().setAttribute("CartInfo", m);
		response.sendRedirect(request.getContextPath() + "/user/cart1.jsp");
	}

}
