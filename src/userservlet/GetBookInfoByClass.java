package userservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import service.UserService;

@WebServlet(description = "����ͼ������ȡͼ��", urlPatterns = { "/GetBookInfoByClass" })
public class GetBookInfoByClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBookInfoByClass() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * ����ͼ������ѯͼ��
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		String bookClass = request.getParameter("bookClass");
		request.getSession().setAttribute("SearchClass", bookClass);
		request.getSession().removeAttribute("SearchName");
		String storeName = request.getParameter("storeName");
		String page = request.getParameter("page");
		int curPage = page==null?1:Integer.parseInt(page);
		// ��ѯͼ��
		UserService us = new UserService();
		PageBean pb = us.getBookByClass(storeName, bookClass, curPage);
		if(pb != null) {
			// ��ѯ�ɹ������棬����ǰ��
			request.getSession().setAttribute("BookInfo", pb);
			String url = "/index.jsp";
			url = storeName==null?url:"/store.jsp";
			response.sendRedirect(request.getContextPath() + url);
		} else {
			// ��ѯʧ��
			response.getWriter().println("<script>alert('ҵ���쳣����ѯʧ�ܣ�')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
