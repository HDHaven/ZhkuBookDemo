package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import bean.Cart;
import bean.Comment;
import bean.Order;
import bean.PageBean;
import bean.Product;
import bean.TempStore;
import bean.User;
import dao.BookDAO;
import dao.CartDAO;
import dao.CommentDAO;
import dao.OrderDAO;
import dao.StoreDAO;
import dao.UserDAO;

/**
 * �û�ҵ�����ࣺ������¼��ע�ᡢ�޸�����͵�ַ�����ﳵ������������ͼ���ѯ
 * 
 * ���ﳵ����	(1)�鿴���ﳵ������Ʒ����������ʾ��
 * 			  	(2)���빺�ﳵ����һ����Ʒ��¼�����ﳵ��
 * 				(3)�Ƴ����ﳵ���ӹ��ﳵ�Ƴ�ѡ�м�¼��
 * 				(4)�޸���Ʒ�������޸Ĺ��ﳵ����Ʒ�Ĺ���������
 * 
 * ��������	(1)��Ӷ������Ȳ���һ��������Ϣ���ٸ��ݶ�����Ų��빺�����Ʒ��Ϣ�б�
 * 				   ����ͼ��Ŀ�����������������ݵ��������µ��̵����������������۶ɾ�����ﳵ��¼
 * 				(2)�鿴�����������û����鿴���ж���-->���ݶ�����Ų鿴������Ʒ��Ϣ�����ݶ���״̬��ȡ������Ϣ-->���ݶ�����Ż�ȡ������ϸ��Ϣ��
 * 				(3)ȡ�����������ݶ�������޸Ķ���״̬��
 * 				(4)���۶���
 * 
 * @author �ƻ���
 *
 */
@SuppressWarnings("rawtypes")
public class UserService {
	private UserDAO uDao;
	private BookDAO bDao;
	private StoreDAO sDao;
	private CartDAO cDao;
	private OrderDAO oDao;
	private CommentDAO comDao;
	
	public UserService() {
		uDao = new UserDAO();
		bDao = new BookDAO();
		sDao = new StoreDAO();
		cDao = new CartDAO();
		oDao = new OrderDAO();
		comDao = new CommentDAO();
	}
	
	/**
	 * ���ܣ������û���¼�������û�����
	 * @param userName
	 * @param password
	 * @return �ɹ��򷵻��û�����('1'��ʾ��ͨ�û���'2'��ʾ����Ա)�����򷵻�0��
	 */
	public int login(String userName, String password) {
		return uDao.login(userName, password);
	}
	
	/**
	 * ���ܣ������û�ע��
	 * @param userName
	 * @param password
	 * @return �û����Ѵ����򷵻�1��ע��ɹ��򷵻�2�����򷵻�0��
	 */
	public int register(String userName, String password) {
		int recNo = 0;
		// �ж��û����Ƿ��Ѿ�����
		if(uDao.isExisted(userName)) {
			recNo = 1;	// �û����Ѵ��ڣ�ע��ʧ��
			// ִ��ע�����
		} else if(uDao.register(userName, password)) {
			// ע��ɹ�
			recNo = 2;
		}
		return recNo;
	}
	
	/**
	 * ���ܣ������û����鿴�û��ջ���ַ��
	 * @param userName
	 * @return �ɹ��򷵻ظ�����Ϣ�����򷵻�null��
	 */
	public Map getAddr(String userName) {
		return uDao.getUserByName(userName);
	}
	
	/**
	 * ���ܣ������û��޸�����
	 * @param u
	 * @param newPassword
	 * @return ��ԭ���벻��ȷ������0�����޸ĳɹ�������2�����޸�ʧ�ܣ�����1��
	 */
	public int updatePassword(User u, String newPassword) {
		int recNo = 0;
		// ������֤ԭ�����Ƿ���ȷ
		if(uDao.login(u.getUserName(),u.getPassword()) > 0) {
			// ԭ������ȷ��ִ���޸��������
			if(uDao.updatePassword(u.getUserName(), newPassword)) {
				// �޸�����ɹ�
				recNo = 2;
			} else {
				// �޸�ʧ��
				recNo = 1;
			}
		}
		return recNo;
	}
	
	/**
	 * ���ܣ������û��޸ĵ�ַҵ��
	 * @param u
	 * @return �޸ĳɹ��򷵻�true�����򷵻�false��
	 */
	public boolean updateAddr(User u) {
		return uDao.updateAddr(u);
	}
	
	/**
	 * ���ܣ������û����������ʾ������Ϣ
	 * @param storeName
	 * @return �ɹ��򷵻�һ��������Ϣ�����򷵻�null��
	 */
	public Map enterStore(String storeName) {
		return sDao.getStoreByName(storeName);
	}
	
	/**
	 * ���ܣ������û�����ͼ�������ڲ�ѯͼ��
	 * @param bookName
	 * @param curPage
	 * @return �ɹ��򷵻�ͼ����Ϣ�б����򷵻�null��
	 */
	public PageBean getBookByName(String storeName, String bookName, int curPage) {
		if(storeName == null) {
			// ���������Ϊ�գ�ȫ������
			return bDao.getBookByName(bookName, curPage);
		} else {
			// �����ڵ���������
			return bDao.getBookByNameInStore(storeName, bookName, curPage);
		}
	}
	
	/**
	 * ���ܣ������û�����ͼ������ڲ�ѯͼ��
	 * @param bookClass
	 * @param curPage
	 * @return �ɹ��򷵻�ͼ����Ϣ�б����򷵻�null��
	 */
	public PageBean getBookByClass(String storeName, String bookClass, int curPage) {
		if(storeName == null) {
			// ������Ϊ�գ�ȫ������
			return bDao.getBookByClass(bookClass, curPage);
		} else {
			// �����ڵ���������
			return bDao.getBookByClassInStore(storeName, bookClass, curPage);
		}
	}
	
	/**
	 * ���ܣ��û��������ʱִ�У���ʾ�����������ϴ���4����
	 * @param storeName
	 * @return �ɹ��򷵻�ͼ����Ϣ�б����򷵻�null��
	 */
	public List getBookByLastDate(String storeName) {
		if(storeName == null) {
			// ���������Ϊ�գ�ȫ�ֻ�ȡ
			return bDao.getBookByLastDate();
		}
		return bDao.getBookByLastDateInStore(storeName);
	}
	
	/**
	 * ���ܣ��û��������ʱִ�У���ʾ������������õ�4����
	 * @param storeName
	 * @return �ɹ��򷵻�ͼ����Ϣ�б����򷵻�null��
	 */
	public List getBookByHotSale(String storeName) {
		if(storeName == null) {
			// ���������Ϊ�գ�ȫ�ֻ�ȡ
			return bDao.getBookByHotSale();
		}
		return bDao.getBookByHotSaleInStore(storeName);
	}
	
	/**
	 * ���ܣ������û����뿪����
	 * @param ts
	 * @return ���������Ѵ����򷵻�1��������ɹ�����2�����򷵻�0��
	 */
	public int addStore(TempStore ts) {
		int recNo = 0;
		// �����жϵ����Ƿ��Ѿ�����
		if(sDao.isExisted(ts.getTempStoreName()) && sDao.isExistInStore(ts.getTempStoreName())) {
			// �������Ѵ���
			recNo = 1;
		} else if(sDao.addTempStore(ts)) {
			// ��ӽ�����ʱ���̱�
			recNo = 2;
		}
		return recNo;
	}
	
	/**
	 * ���ܣ������û������Ʒ���������
	 * @param c
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean addBookInCart(Cart c) {
		boolean success = false;
		// �����жϹ��ﳵ�Ƿ��Ѵ��ڸü���Ʒ
		if(cDao.isExisted(c.getUserName(), c.getStoreName(), c.getBookName())) {
			// ���ﳵ���Ѵ��ڣ������κβ�������true
			success = true;
		} else if(cDao.addBookInCart(c)) { // �����ڣ�ִ����Ӳ���
			// ��ӳɹ�
			success = true;
		}
		return success;
	}
	
	/**
	 * ���ܣ������û��޸Ĺ��ﳵ��ͼ������
	 * @param cartId
	 * @param bookNumber
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean updateCart(int cartId, int bookNumber) {
		return cDao.updateCart(cartId, bookNumber);
	}
	
	/**
	 * ���ܣ������û�ɾ�����ﳵ�е�ͼ��
	 * @param cartId
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean deleteFromCart(int cartId) {
		return cDao.deleteFromCart(cartId);
	}
	
	/**
	 * ���ܣ������û��鿴���ﳵ���ܣ����ص����ݽṹ��Map<String,List<Map<String,String>>>
	 * @param userName
	 * @return �ɹ��򷵻ع��ﳵ��Ʒ�б���Ϣ�����򷵻�null��
	 */
	@SuppressWarnings("unchecked")
	public Map getCartByUserName(String userName) {
		Map m = null;
		// (1)�����û��������û��Ĺ��ﳵ�а����˼��ҵ��̵���Ʒ
		List list = cDao.getStoreNameInCart(userName); 
		if(list != null && !list.isEmpty()) {	// ���ﳵ������Ʒ
			m = new HashMap();
			// (2)�����û����͵�������ȡ���ﳵ����Ʒ��Ϣ�б�
			for(int i = 0; i < list.size(); i++) {
				Map mm = (Map) list.get(i);
				List cartList = cDao.getBookByStoreName(userName, (String) mm.get("storeName"));
				m.put((String)mm.get("storeName"), cartList);
			}
		}
		return m;
	}
	
	/**
	 * ���ܣ������û��޸Ķ���״̬��ȡ������ҵ��
	 * @param orderId
	 * @param newOrderState
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean updateOrderState(int productId, String newOrderState) {
		return oDao.updateOrderState(productId, newOrderState);
	}
	
	/**
	 * ���ܣ���Ӷ���ҵ�����µ��ɹ����޸Ķ�Ӧͼ��Ŀ�������������Լ���Ӧ���̵���������
	 *       �µ�������Դ�ڹ��ﳵ��ɾ�����ﳵ�е���Ʒ��Ϣ
	 * @param o
	 * @param cartList �ӹ��ﳵ�л�ȡ��ѡ�е���Ʒ��Cart����
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean addOrder(Order o, List cartList) {
		boolean success = false;
		// ������Ӷ�����Ϣ
		if(oDao.addOrder(o)) {
			// ��ӳɹ�����ȡ�������
			Map m = oDao.getOrderId(o.getUserName(), o.getOrderDate());
			int orderId = (int) m.get("orderId");
			String userName = o.getUserName();
			String orderState = "������";
			for (Object obj : cartList) {
				Cart c = (Cart) obj;
				Product p = new Product(0, orderId, userName, c.getStoreName(), 
						c.getBookName(), c.getBookPrice(), c.getBookNumber(), c.getBookImage(), orderState);
				if(! oDao.addProduct(p)) // ��Ӷ�����Ӧ��Ʒ�б�ʧ�ܣ�ֱ�ӷ���false��
					return false;
				// ��Ӷ�����Ӧ��Ʒ�б�ɹ����޸Ķ�Ӧͼ����������Ϳ�����Լ���Ӧ���̵����۶����������
				if(bDao.updateBookByOrder(c) && sDao.updateStore(c.getStoreName(), c.getBookNumber(), c.getBookPrice())) {
					// �µ��ɹ����ӹ��ﳵ��ɾ���ѹ������Ʒ
					cDao.deleteFromCart(c.getCartId());
					success = true;
				}
			}
			success = true;
		}
		return success;
	}
	
	/**
	 * ���ܣ������û��鿴������������Ʒ��Ϣ�б�ҵ��
	 * @param orderId
	 * @return �ɹ��򷵻ظö��������������Ʒ��Ϣ�����򷵻�null��
	 */
	public List getOrderProductById(int orderId) {
		return oDao.getOrderProductById(orderId);
	}
	
	/**
	 * ���ܣ������û�����״̬�鿴������ҵ��
	 * @param userName
	 * @param curPage
	 * @return �ɹ��򷵻ض�����Ϣ�б����򷵻�null��
	 */
	public PageBean getOrder(String userName, String orderState, int curPage) {
		if(orderState == null) {
			// �������״̬Ϊ�գ���ȡ���ж���
			return oDao.getOrderByUserName(userName, curPage);
		}
		return oDao.getOrderByStateInUser(userName, orderState, curPage);
	}
	
	/**
	 * ���ܣ������û��鿴������ϸ��Ϣ��ҵ��
	 * @param orderId
	 * @return �ɹ��򷵻�һ��������Ϣ�����򷵻�null��
	 */
	public Map getOrderById(int orderId) {
		return oDao.getOrderDetailById(orderId);
	}
	
	/**
	 * ���ܣ������û�����ͼ�飬ͬʱ�Զ�Ӧ�ĵ������۽����޸�
	 * @param c
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean addComment(Comment c) {
		boolean success = false;
		// ������ۣ�ͬʱ�޸ĵ�������
		if(comDao.addComment(c) && sDao.updateStoreEvaluate(c)) {
			success = true;
		}
		return success;
	}
	
	/**
	 * ���ܣ������û��鿴ͼ����ϸ��Ϣʱ����ʾ��ͼ���������Ϣ��
	 * @param storeName
	 * @param bookName
	 * @param curPage
	 * @return �ɹ��򷵻�������Ϣ�б����򷵻�null��
	 */
	public PageBean getBookComment(String storeName, String bookName, int curPage) {
		return comDao.getComment(storeName, bookName, curPage);
	}
	
	/**
	 * ���ܣ������û��鿴ͼ����ϸ��Ϣҵ��
	 * @param bookId
	 * @return �ɹ��򷵻�ͼ�����飬���򷵻�null��
	 */
	public Map getBookById(int bookId) {
		return bDao.getBookById(bookId);
	}
	
	/**
	 * ���ܣ��ж��û��Ƿ�Ϊ���
	 * @param userName
	 * @return ���򷵻�true�����򷵻�false��
	 */
	public boolean isManager(String userName) {
		boolean success = false;
		if(sDao.getStoreByUserName(userName) != null) {
			// �ǵ��
			success = true;
		}
		return success;
	}
	
	/**
	 * ���ܣ���ȡ�û��ӹ�����ѡ�е���Ʒ
	 * @param userName
	 * @param request
	 * @return �ɹ��򷵻���Ʒ�б����򷵻�null��
	 */
	@SuppressWarnings("unchecked")
	public List getProdcutList(String userName, HttpServletRequest request) {
		List productList = new ArrayList();
		// (1)��ȡ�û����ﳵ�б�
		List cartList = cDao.getCartByUserName(userName);
		if(cartList != null && cartList.size() > 0) {
			// ���ﳵ��Ϊ�գ���������ȡ�û�ѡ�е���Ʒ�����
			for (Object obj : cartList) {
				Map m = (Map) obj;
				int cartId = (int) m.get("cartId");
				if(request.getParameter(""+ cartId).equals("true")) {
					// (2)����Ʒ��ѡ��
					Cart c = new Cart();
					c.setCartId(cartId);
					c.setBookImage((String) m.get("bookImage"));
					c.setBookName((String) m.get("bookName"));
					c.setBookNumber((int) m.get("bookNumber"));
					c.setBookPrice((int) m.get("bookPrice"));
					c.setStoreName((String) m.get("storeName"));
					c.setUserName((String) m.get("userName"));
					productList.add(c);
				}
			}
		}
		return productList;	// ������Ʒ�б���Ϣ
	}
	
	public Map getABook(String storeName, String bookName) {
		return bDao.getABook(storeName, bookName);
	}
	
}
