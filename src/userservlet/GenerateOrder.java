package userservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet(description = "�ӹ��ﳵ�����ɶ���", urlPatterns = { "/user/GenerateOrder" })
public class GenerateOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GenerateOrder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �ӹ��ﳵ��ȡ��ѡ�е���Ʒ�����ɶ���
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		String userName = (String) request.getSession().getAttribute("LoginUser");
		String sumPrice = request.getParameter("sumPrice");	// �����ܼ�
		// ��ȡѡ�е���Ʒ
		UserService us = new UserService();
		List productList = us.getProdcutList(userName, request);
		if(productList != null && productList.size() > 0) {
			// ��ȡ�ɹ������棬����ǰ��
			request.getSession().setAttribute("SumPrice", sumPrice);
			request.getSession().setAttribute("ProductList", productList);
			response.sendRedirect(request.getContextPath() +"/user/addOrder.jsp");
		} else {
			// ��ȡʧ�ܣ���ʾ������Ϣ
			response.getWriter().println("<script>alert('ҵ���쳣������ʧ�ܣ�')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
