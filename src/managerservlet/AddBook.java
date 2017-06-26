package managerservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import service.ManagerService;
import util.UploadFile;

@WebServlet(description = "���һ��ͼ��", urlPatterns = { "/manager/AddBook" })
@MultipartConfig
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * ������һ��ͼ��
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡͼ����Ϣ
		String storeName = (String) request.getSession().getAttribute("StoreName");
		String bookISBN = request.getParameter("bookISBN");
		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");
		String bookPublisher = request.getParameter("bookPublisher");
		int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
		int bookSumNum = Integer.parseInt(request.getParameter("bookSumNum"));
		String bookClass = request.getParameter("bookClass");
		String bookPage = request.getParameter("bookPage");
		String bookDescript = request.getParameter("bookDescript");
		// ��ȡͼ�����
		String bookImage = UploadFile.uploadFile(request, response, storeName);
		if(bookImage == null) {
			response.getWriter().println("<script>alert('�ϴ�ͼ�����ʧ��')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
			return;
		}
		Book b = new Book(0, storeName, bookISBN, bookName, bookAuthor, bookPublisher, bookPrice, 0, bookSumNum, bookClass, bookPage, bookDescript, bookImage);
		// ���ͼ��
		ManagerService ms = new ManagerService();
		String msg = "��ͼ�����Ѵ���";
		if(ms.addBook(b)) 
			// ��ӳɹ�����ת��ͼ�����ҳ��
			msg = "��ӳɹ�";
		response.getWriter().println("<script>alert('"+ msg +"')</script>");
		response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/manager/addBook.jsp");
	}

}
