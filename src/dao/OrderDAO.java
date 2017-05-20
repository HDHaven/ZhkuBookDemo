package dao;

import bean.Order;
import bean.PageBean;
import util.DBUtil;

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
		String sql = "select * from tb_Order where userName=? ";
		String[] params = { userName };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
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
		String sql = "select * from tb_Order where userName = ? and orderState = ? ";
		String[] params = { userName, orderState };
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
		String sql = "select * from tb_Order where storeName = ? ";
		String[] params = { storeName };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
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
		String sql = "select * from tb_Order where storeName = ? and orderState = ? ";
		String[] params = { storeName, orderState };
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
		String sql = "insert into tb_Order values(null,?,?,?,?,?,?,?,?,?) ";
		String[] params = {
				o.getStoreName(),o.getOrderDate(),o.getOrderPrice(),o.getOrderState(),
				o.getOrderConsignee(),o.getOrderAddr(),o.getOrderPhone(),
				o.getUserName(),o.getProductList()
		};
		if(db.update(sql, params) > 0) {
			success = true;	// ��ӳɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ������û����Ͷ������ڶԶ���״̬�����޸�
	 * @param userName
	 * @param orderDate
	 * @param newOrderState
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean updateOrderState(String userName, String orderDate, String newOrderState) {
		boolean success = false;
		String sql = "update tb_Order set orderState = ? where userName = ? and orderDate = ? ";
		String[] params = { newOrderState, userName, orderDate };
		if(db.update(sql, params) > 0) {
			success = true;	// �޸ĳɹ�
		}
		return success;
	}
	
}
