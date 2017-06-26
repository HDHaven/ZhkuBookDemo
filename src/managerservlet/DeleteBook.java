package managerservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ManagerService;

@WebServlet(description = "����ͼ����ɾ��ͼ��", urlPatterns = { "/manager/DeleteBook" })
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * ����ͼ����ɾ��ͼ��
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		String bookId = request.getParameter("bookId");
		String curPage = request.getParameter("page");
		// ɾ��ͼ��
		ManagerService ms = new ManagerService();
		if(ms.deleteBook(Integer.parseInt(bookId))) {
			// ɾ���ɹ�������ͼ�鵱ǰҳ
			response.sendRedirect(request.getContextPath() +"/manager/GetBook?page="+ curPage);
		} else {
			// ɾ��ʧ�ܣ���ʾ������Ϣ������
			response.getWriter().println("<script>alert('ҵ���쳣���޸�ʧ�ܣ�')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
