package adminservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminService;

@WebServlet(description = "ÐÞ¸ÄµêÆÌ×´Ì¬", urlPatterns = { "/admin/UpdateStoreState" })
public class UpdateStoreState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateStoreState() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * ÐÞ¸ÄµêÆÌ×´Ì¬
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storeName = request.getParameter("storeName");
		String storeState = request.getParameter("storeState");
		String curPage = request.getParameter("page");
		// ÐÞ¸ÄµêÆÌ×´Ì¬
		AdminService as = new AdminService();
		if(! as.udpateStoreState(storeName, storeState)) {
			// ÐÞ¸ÄÊ§°Ü£¬ÌáÊ¾´íÎóÐÅÏ¢
			response.getWriter().println("<script>alert('ÒµÎñÒì³££¬²Ù×÷Ê§°Ü£¡')</script>");
		}
		response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/admin/GetAllStore?page="+ curPage);
	}

}
