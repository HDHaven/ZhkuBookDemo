package adminservlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PageBean;
import bean.TempStore;
import service.AdminService;

@WebServlet(description = "添加店铺", urlPatterns = { "/admin/AddStore" })
public class AddStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddStore() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 管理员添加店铺
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取管理员要添加的店铺
		String index = request.getParameter("index");
		PageBean pb = (PageBean) request.getSession().getAttribute("TempStoreInfo");
		List list = pb.getData();
		Map m = (Map) list.get(Integer.parseInt(index));
		TempStore ts = new TempStore();
		ts.setTempStoreId((int)m.get("tempStoreId"));
		ts.setUserName((String) m.get("userName"));
		ts.setTempStoreName((String) m.get("tempStoreName"));
		ts.setTempStoreDescript((String) m.get("tempStoreDescript"));
		ts.setTempStoreLicense((String) m.get("tempStoreLicense"));
		// 添加店铺
		AdminService as = new AdminService();
		if(! as.addStore(ts)) {
			// 添加失败，提示错误信息
			response.getWriter().println("<script>alert('业务异常，添加失败！')</script>");
		}  
		// 添加成功，重新获取该页临时店铺信息
		response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/admin/GetTempStore?page="+ pb.getCurPage());
			
	}

}
