package managerservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ManagerService;

@WebServlet(description = "�޸�ͼ��۸��ȡ�����", urlPatterns = { "/manager/UpdateBook" })
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �޸�ͼ��ļ۸���߿����
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String bookPrice = request.getParameter("bookPrice");
		String bookSumNum = request.getParameter("bookSumNum");
		String curPage = request.getParameter("page");
		// �޸�ͼ����Ϣ
		ManagerService ms = new ManagerService();
		if(bookPrice != null && ms.updateBookPrice(bookId, Integer.parseInt(bookPrice))) {
			// �޸ļ۸�ɹ�
			response.sendRedirect(request.getContextPath() +"/manager/GetBook?page="+ curPage);
		} else if(bookSumNum != null && ms.updateBookSumNum(bookId, Integer.parseInt(bookSumNum))) {
			// �޸Ŀ�����ɹ������·��ص�ǰҳͼ����Ϣ
			response.sendRedirect(request.getContextPath() +"/manager/GetBook?page="+ curPage);
		} else {
			// �޸�ʧ�ܣ���ʾ������Ϣ�����ء�
			response.getWriter().println("<script>alert('ҵ���쳣���޸�ʧ��')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
