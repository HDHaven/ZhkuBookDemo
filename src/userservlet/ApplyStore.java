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

@WebServlet(description = "用户申请开店铺", urlPatterns = { "/user/ApplyStore" })
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
	 * 用户申请开店铺，提交信息包括店铺名、店铺描述、营业执照
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String userName = (String) request.getSession().getAttribute("LoginUser");
		String storeName = request.getParameter("storeName");
		String storeDescript = request.getParameter("storeDescript");
		String storeLicense = UploadFile.uploadFile(request, response, "licenses");
		if(storeLicense == null) {
			// 上传营业执照失败
			response.getWriter().println("<script>alert('上传图片失败！')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
			return;
		}
		// 将申请店铺信息保存到临时店铺表中
		UserService us = new UserService();
		int recNo = us.addStore(new TempStore(0, userName, storeName, storeDescript, storeLicense));
		if(recNo == 2) {
			// 申请成功
			response.getWriter().println("<script>alert('申请成功，请等待处理！')</script>");
			response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/user/applyStore.jsp");
		} else {
			// 申请失败
			String msg = "业务异常，申请失败！";
			if(recNo == 1)
				msg = "店铺名已存在！";
			response.getWriter().println("<script>alert('"+ msg +"')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
