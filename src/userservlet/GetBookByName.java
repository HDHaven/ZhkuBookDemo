package userservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import service.UserService;

@WebServlet(name = "GetBookInfoByName", description = "����ͼ������ȡͼ����Ϣ", urlPatterns = { "/GetBookInfoByName" })
public class GetBookByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBookByName() {
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
		String bookName = request.getParameter("bookName");
		request.getSession().setAttribute("SearchName", bookName);
		request.getSession().removeAttribute("SearchClass");
		String storeName = request.getParameter("storeName");
		String page = request.getParameter("page");
		int curPage = page==null?1:Integer.parseInt(page);
		// ��ȡͼ��
		UserService us = new UserService();
		PageBean pb = us.getBookByName(storeName, bookName, curPage);
		String url = "/index.jsp";
		url = storeName==null?url:"/store.jsp";
		if(pb != null) {
			// ��ѯ�ɹ������棬����ǰ��
			request.getSession().setAttribute("BookInfo", pb);
			response.sendRedirect(request.getContextPath() + url);
		} else {
			// ��ѯʧ��
			response.getWriter().println("<script>alert('��ѯ���Ϊ�գ�')</script>");
			response.setHeader("Refresh", "1; url="+ request.getContextPath() + url);
		}
	}

}
