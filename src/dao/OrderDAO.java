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
		String sql = "select * from tb_Order where userName=? order by orderId desc";
		Object[] params = { userName };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
	}
	
	/**
	 * 功能：根据订单编号获取该订单包含的商品信息
	 * @param orderId 
	 * @return 成功则返回商品信息列表，否则返回null。
	 */
	public List getOrderProductById(int orderId) {
		List list = null;
		String sql = "select * from tb_Product where orderId = ?";
		Object[] params = { orderId };
		list = db.getList(sql, params);
		return list;
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
		String sql = "select * from tb_Product where userName = ? and orderState = ? ";
		Object[] params = { userName, orderState };
		pb = db.getPageBean(sql, params, curPage);
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
		String sql = "select * from tb_Product where storeName = ? ";
		Object[] params = { storeName };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
	}
	
	/**
	 * 功能：根据订单编号获取订单收货信息
	 * @param orderId
	 * @return 成功则返回订单信息，否则返回null。
	 */
	public Map getOrderDetailById(int orderId) {
		Map m = null;
		String sql = "select * from tb_Order where orderId = ? ";
		Object[] params = { orderId };
		m = db.getMap(sql, params);
		return m;
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
		String sql = "select * from tb_Product where storeName = ? and orderState = ? ";
		Object[] params = { storeName, orderState };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
	}
	
	/**
	 * 功能：往数据库添加一条订单记录
	 * @param o
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean addOrder(Order o) {
		boolean success = false;
		String sql = "insert into tb_Order values(null,?,?,?,?,?,?) ";
		Object[] params = { o.getOrderDate(), o.getOrderPrice(), o.getOrderConsignee(),
				o.getOrderAddr(), o.getOrderPhone(), o.getUserName()
		};
		if(db.update(sql, params) > 0) {
			success = true;	// 添加成功
		}
		return success;
	}
	
	/**
	 * 功能：根据用户名和订单日期获取订单编号，用于添加订单商品信息
	 * @param userName
	 * @param orderDate
	 * @return 成功则返回订单编号，否则返回null。
	 */
	public Map getOrderId(String userName, String orderDate) {
		Map m = null;
		String sql = "select orderId from tb_Order where userName = ? and orderDate = ? ";
		String[] params = { userName, orderDate };
		m = db.getMap(sql, params);
		return m;
	}
	
	/**
	 * 功能：添加订单商品信息
	 * @param p
	 * @return 成功则返回true，否则返回false。
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
	 * 功能：根据商品编号对订单状态进行修改
	 * @param productId
	 * @param newOrderState
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean updateOrderState(int productId, String newOrderState) {
		boolean success = false;
		String sql = "update tb_Product set orderState = ? where productId = ? ";
		Object[] params = { newOrderState, productId };
		if(db.update(sql, params) > 0) {
			success = true;	// 修改成功
		}
		return success;
	}
	
}
