package managerservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import service.ManagerService;

@WebServlet(description = "����������ѯͼ��", urlPatterns = { "/manager/GetBookByName" })
public class GetBookByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBookByName() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * ����������ȡͼ��
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		String storeName = (String) request.getSession().getAttribute("StoreName");
		String bookName = request.getParameter("bookName");
		request.getSession().setAttribute("BookName", bookName);
		String page = request.getParameter("page");
		int curPage = 1;
		if(page != null && page.length() > 0)
			curPage = Integer.parseInt(page);
		// ��ȡͼ����Ϣ
		ManagerService ms = new ManagerService();
		PageBean pb = ms.getBookByNameInStore(storeName, bookName, curPage);
		if(pb != null) {
			// ��ȡ�ɹ����������ݣ�����ǰ��
			request.getSession().setAttribute("BookInfo", pb);
			response.sendRedirect(request.getContextPath() +"/manager/bookInfo.jsp");
		} else {
			// ��ѯ����������Ϊ�գ���ʾ������Ϣ
			response.getWriter().println("<script>alert('��ѯ���Ϊ�գ�')</script>");
			response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/manager/bookInfo.jsp");
		}
	}

}
