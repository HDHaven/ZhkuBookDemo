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
		
		return pb;
	}
	
	/**
	 * ���ܣ������ݿ����һ��������¼
	 * @param order
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean addOrder(Order order) {
		boolean success = false;
		
		return success;
	}
	
	/**
	 * ���ܣ����ݶ�����ŶԶ���״̬�����޸�
	 * @param orderId
	 * @param newOrderState
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean updateOrderState(int orderId, String newOrderState) {
		boolean success = false;
		
		return success;
	}
	
}
