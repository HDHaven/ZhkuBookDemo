package managerservlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ManagerService;

@WebServlet(description = "店家进入店铺返回店铺信息", urlPatterns = { "/manager/EnterStore" })
public class EnterStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EnterStore() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 店家进入自家店铺对图书和订单进行处理
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("ManagerUser");
		// 获取店铺基本信息
		ManagerService ms = new ManagerService();
		Map m = ms.enterStore(userName);
		if(m != null) {
			// 获取成功，进入店铺
			request.getSession().setAttribute("StoreInfo", m);
			request.getSession().setAttribute("StoreName", m.get("storeName"));
			response.sendRedirect(request.getContextPath() +"/manager/index.jsp");
		} else {
			// 进入失败，提示错误信息
			response.getWriter().println("<script>alert('业务异常，无法进入店铺')</script>");
			response.setHeader("Refresh", "1; url=javascript:hisotry.go(-1)");
		}
	}

}
