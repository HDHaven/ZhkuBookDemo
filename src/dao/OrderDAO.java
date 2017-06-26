package dao;

import java.util.List;
import java.util.Map;

import bean.Order;
import bean.PageBean;
import bean.Product;
import util.DBUtil;

@SuppressWarnings("rawtypes")
public class OrderDAO {
	/**
	 * �������ݷ��ʲ�
	 */
	private DBUtil db;
	
	public OrderDAO() {
		db = new DBUtil();
	}
	
	/**
	 * ���ܣ������û�����ȡ�û����ж�����Ϣ����ҳ��ʾ
	 * @param userName
	 * @param curPage
	 * @return �ɹ��򷵻ض�����Ϣ�б����򷵻�null��
	 */
	public PageBean getOrderByUserName(String userName, int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_Order where userName=? order by orderId desc";
		Object[] params = { userName };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
	}
	
	/**
	 * ���ܣ����ݶ�����Ż�ȡ�ö�����������Ʒ��Ϣ
	 * @param orderId 
	 * @return �ɹ��򷵻���Ʒ��Ϣ�б����򷵻�null��
	 */
	public List getOrderProductById(int orderId) {
		List list = null;
		String sql = "select * from tb_Product where orderId = ?";
		Object[] params = { orderId };
		list = db.getList(sql, params);
		return list;
	}
	
	/**
	 * ���ܣ������û����Ͷ���״̬��ȡ������Ϣ����ҳ��ʾ
	 * @param userName
	 * @param orderState
	 * @param curPage ��ǰҳ
	 * @return �ɹ��򷵻ض�����Ϣ�б����򷵻�null��
	 */
	public PageBean getOrderByStateInUser(String userName, String orderState, int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_Product where userName = ? and orderState = ? ";
		Object[] params = { userName, orderState };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
	}
	
	/**
	 * ���ܣ����ݵ������ƻ�ȡ�����ڵ����ж�����Ϣ����ҳ��ʾ
	 * @param storeName
	 * @param curPage
	 * @return �ɹ��򷵻ض�����Ϣ�б����򷵻�null��
	 */
	public PageBean getOrderByStoreName(String storeName, int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_Product where storeName = ? ";
		Object[] params = { storeName };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
	}
	
	/**
	 * ���ܣ����ݶ�����Ż�ȡ�����ջ���Ϣ
	 * @param orderId
	 * @return �ɹ��򷵻ض�����Ϣ�����򷵻�null��
	 */
	public Map getOrderDetailById(int orderId) {
		Map m = null;
		String sql = "select * from tb_Order where orderId = ? ";
		Object[] params = { orderId };
		m = db.getMap(sql, params);
		return m;
	}
	
	/**
	 * ���ܣ����ݵ������ƺͶ���״̬��ȡ������Ϣ����ҳ��ʾ
	 * @param storeName
	 * @param orderState
	 * @param curPage
	 * @return �ɹ��򷵻ض�����Ϣ�б����򷵻�null��
	 */
	public PageBean getOrderByStateInStore(String storeName, String orderState, int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_Product where storeName = ? and orderState = ? ";
		Object[] params = { storeName, orderState };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
	}
	
	/**
	 * ���ܣ������ݿ����һ��������¼
	 * @param o
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean addOrder(Order o) {
		boolean success = false;
		String sql = "insert into tb_Order values(null,?,?,?,?,?,?) ";
		Object[] params = { o.getOrderDate(), o.getOrderPrice(), o.getOrderConsignee(),
				o.getOrderAddr(), o.getOrderPhone(), o.getUserName()
		};
		if(db.update(sql, params) > 0) {
			success = true;	// ��ӳɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ������û����Ͷ������ڻ�ȡ������ţ�������Ӷ�����Ʒ��Ϣ
	 * @param userName
	 * @param orderDate
	 * @return �ɹ��򷵻ض�����ţ����򷵻�null��
	 */
	public Map getOrderId(String userName, String orderDate) {
		Map m = null;
		String sql = "select orderId from tb_Order where userName = ? and orderDate = ? ";
		String[] params = { userName, orderDate };
		m = db.getMap(sql, params);
		return m;
	}
	
	/**
	 * ���ܣ���Ӷ�����Ʒ��Ϣ
	 * @param p
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean addProduct(Product p) {
		boolean success = false;
		String sql = "insert into tb_Product values(null,?,?,?,?,?,?,?,?);";
		Object[] params = {
				""+p.getOrderId(), p.getUserName(), p.getStoreName(), p.getBookName(),
				p.getBookPrice(), p.getBookNumber(), p.getBookImage(), p.getOrderState()
		};
		if(db.update(sql, params) > 0) {
			success = true;
		}
		return success;
	}
	
	/**
	 * ���ܣ�������Ʒ��ŶԶ���״̬�����޸�
	 * @param productId
	 * @param newOrderState
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean updateOrderState(int productId, String newOrderState) {
		boolean success = false;
		String sql = "update tb_Product set orderState = ? where productId = ? ";
		Object[] params = { newOrderState, productId };
		if(db.update(sql, params) > 0) {
			success = true;	// �޸ĳɹ�
		}
		return success;
	}
	
}
