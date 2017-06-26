package userservlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet(name = "EnterStores", description = "用户进入店铺", urlPatterns = { "/EnterStores" })
public class EnterStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EnterStore() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 用户进入店铺，获取店铺最近上新或最近热卖
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String storeName = request.getParameter("storeName");
		// 进入店铺
		UserService us = new UserService();
		Map m = us.enterStore(storeName);
		if(m != null) {
			// 成功进入店铺，获取最新上传和最近热卖图书，传给前端
			request.getSession().setAttribute("StoreInfo", m);
			request.getSession().setAttribute("StoreNewUpload", us.getBookByLastDate(storeName));
			request.getSession().setAttribute("StoreHotSale", us.getBookByHotSale(storeName));
			response.sendRedirect(request.getContextPath() +"/store.jsp");
		} else {
			// 进入失败
			response.getWriter().println("<script>alert('业务异常！')</script>");
			response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/index.jsp");
		}
	}

}
