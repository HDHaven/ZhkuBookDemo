package dao;

import bean.Order;
import bean.PageBean;
import util.DBUtil;

public class OrderDAO {
	/**
	 * 订单数据访问层
	 */
	private DBUtil db;
	
	public OrderDAO() {
		db = new DBUtil();
	}
	
	/**
	 * 功能：根据用户名获取用户所有订单信息，分页显示
	 * @param userName
	 * @param curPage
	 * @return 成功则返回订单信息列表，否则返回null。
	 */
	public PageBean getOrderByUserName(String userName, int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_Order where userName=? ";
		String[] params = { userName };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
	}
	
	/**
	 * 功能：根据用户名和订单状态获取订单信息，分页显示
	 * @param userName
	 * @param orderState
	 * @param curPage 当前页
	 * @return 成功则返回订单信息列表，否则返回null。
	 */
	public PageBean getOrderByStateInUser(String userName, String orderState, int curPage) {
		PageBean pb = null;
		
		return pb;
	}
	
	/**
	 * 功能：根据店铺名称获取店铺内的所有订单信息，分页显示
	 * @param storeName
	 * @param curPage
	 * @return 成功则返回订单信息列表，否则返回null。
	 */
	public PageBean getOrderByStoreName(String storeName, int curPage) {
		PageBean pb = null;
		
		return pb;
	}
	
	/**
	 * 功能：根据店铺名称和订单状态获取订单信息，分页显示
	 * @param storeName
	 * @param orderState
	 * @param curPage
	 * @return 成功则返回订单信息列表，否则返回null。
	 */
	public PageBean getOrderByStateInStore(String storeName, String orderState, int curPage) {
		PageBean pb = null;
		
		return pb;
	}
	
	/**
	 * 功能：往数据库添加一条订单记录
	 * @param order
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean addOrder(Order order) {
		boolean success = false;
		
		return success;
	}
	
	/**
	 * 功能：根据订单编号对订单状态进行修改
	 * @param orderId
	 * @param newOrderState
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean updateOrderState(int orderId, String newOrderState) {
		boolean success = false;
		
		return success;
	}
	
}
