package userservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.TempStore;
import service.UserService;
import util.UploadFile;

@WebServlet(description = "�û����뿪����", urlPatterns = { "/user/ApplyStore" })
@MultipartConfig
public class ApplyStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApplyStore() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * �û����뿪���̣��ύ��Ϣ����������������������Ӫҵִ��
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		String userName = (String) request.getSession().getAttribute("LoginUser");
		String storeName = request.getParameter("storeName");
		String storeDescript = request.getParameter("storeDescript");
		String storeLicense = UploadFile.uploadFile(request, response, "licenses");
		if(storeLicense == null) {
			// �ϴ�Ӫҵִ��ʧ��
			response.getWriter().println("<script>alert('�ϴ�ͼƬʧ�ܣ�')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
			return;
		}
		// �����������Ϣ���浽��ʱ���̱���
		UserService us = new UserService();
		int recNo = us.addStore(new TempStore(0, userName, storeName, storeDescript, storeLicense));
		if(recNo == 2) {
			// ����ɹ�
			response.getWriter().println("<script>alert('����ɹ�����ȴ�����')</script>");
			response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/user/applyStore.jsp");
		} else {
			// ����ʧ��
			String msg = "ҵ���쳣������ʧ�ܣ�";
			if(recNo == 1)
				msg = "�������Ѵ��ڣ�";
			response.getWriter().println("<script>alert('"+ msg +"')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
