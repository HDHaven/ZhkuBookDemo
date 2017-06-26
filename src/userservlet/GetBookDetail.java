package userservlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet(description = "�鿴ͼ����ϸ��Ϣ", urlPatterns = { "/GetBookDetail" })
public class GetBookDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBookDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �鿴ͼ����ϸ��Ϣ����������
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		String bookId = request.getParameter("bookId");
		String page = request.getParameter("page");
		int curPage = page==null?1:Integer.parseInt(page);
		// ��ȡͼ����Ϣ
		UserService us = new UserService();
		Map m = us.getBookById(Integer.parseInt(bookId));
		if(m != null) {
			// �ɹ���ȡͼ����Ϣ����ȡͼ������
			String storeName = (String) m.get("storeName");
			String bookName = (String) m.get("bookName");
			request.getSession().setAttribute("BookComment", us.getBookComment(storeName, bookName, curPage));
			request.getSession().setAttribute("BookDetail", m);
			response.sendRedirect(request.getContextPath() +"/bookDetail.jsp");
		} else {
			// ��ȡʧ��
			response.getWriter().println("<script>alert('ҵ���쳣��')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
