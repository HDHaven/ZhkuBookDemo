package managerservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ManagerService;

@WebServlet(description = "修改订单状态", urlPatterns = { "/manager/UpdateOrderState" })
public class UpdateOrderState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateOrderState() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 根据订单编号修改订单状态
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String productId = request.getParameter("productId");
		String orderState = request.getParameter("orderState");
		String curPage = request.getParameter("page");
		// 修改订单状态
		ManagerService ms = new ManagerService();
		if(ms.updateOrderState(Integer.parseInt(productId), orderState)) {
			// 修改成功，重新获取该页订单信息
			response.sendRedirect(request.getContextPath() +"/manager/GetOrder?page="+ curPage);
		} else {
			// 修改失败，提示错误信息，返回
			response.getWriter().println("<script>alert('业务异常，修改失败！')</script>");
			response.setHeader("Refresh", "1; url=javascript:history.go(-1)");
		}
	}

}
