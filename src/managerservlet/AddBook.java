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

@WebServlet(description = "添加一本图书", urlPatterns = { "/manager/AddBook" })
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
	 * 店家添加一本图书
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取图书信息
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
		// 获取图书封面
		String bookImage = UploadFile.uploadFile(request, response, storeName);
		if(bookImage == null) {
			response.getWriter().println("<script>alert('上传图书封面失败')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
			return;
		}
		Book b = new Book(0, storeName, bookISBN, bookName, bookAuthor, bookPublisher, bookPrice, 0, bookSumNum, bookClass, bookPage, bookDescript, bookImage);
		// 添加图书
		ManagerService ms = new ManagerService();
		String msg = "该图书名已存在";
		if(ms.addBook(b)) 
			// 添加成功，跳转到图书管理页面
			msg = "添加成功";
		response.getWriter().println("<script>alert('"+ msg +"')</script>");
		response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/manager/addBook.jsp");
	}

}
