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

@WebServlet(description = "��ӵ���", urlPatterns = { "/admin/AddStore" })
public class AddStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddStore() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * ����Ա��ӵ���
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����ԱҪ��ӵĵ���
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
		// ��ӵ���
		AdminService as = new AdminService();
		if(! as.addStore(ts)) {
			// ���ʧ�ܣ���ʾ������Ϣ
			response.getWriter().println("<script>alert('ҵ���쳣�����ʧ�ܣ�')</script>");
		}  
		// ��ӳɹ������»�ȡ��ҳ��ʱ������Ϣ
		response.setHeader("Refresh", "1; url="+ request.getContextPath() +"/admin/GetTempStore?page="+ pb.getCurPage());
			
	}

}
