package userservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Comment;
import service.UserService;

@WebServlet("/user/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddComment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �û�����ͼ��
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		String storeName = request.getParameter("storeName");
		String bookName = request.getParameter("bookName");
		String userName = (String) request.getSession().getAttribute("LoginUser");
		String commentScore = request.getParameter("commentScore");
		String commentContent = request.getParameter("commentContent");
		// �������
		Comment c = new Comment(0, userName, storeName, bookName, Integer.parseInt(commentScore), commentContent);
		UserService us = new UserService();
		if(us.addComment(c)) {
			// ���۳ɹ�����������ɶ���ҳ��
			response.sendRedirect(request.getContextPath() +"/user/GetOrderInfo?orderState=�����");
		} else {
			// ����ʧ��
			response.getWriter().println("<script>alert('ҵ���쳣������ʧ��')</script>");
			response.setHeader("Refresh", "2; url="+ request.getContextPath() +"/user/addComment.jsp");
		}
	}

}
